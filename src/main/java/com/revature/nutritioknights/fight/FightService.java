package com.revature.nutritioknights.fight;

import com.revature.nutritioknights.avatar.Avatar;
import com.revature.nutritioknights.avatar.AvatarService;
import com.revature.nutritioknights.fight.dtos.requests.NewFightRequest;
import com.revature.nutritioknights.level.LevelService;
import com.revature.nutritioknights.monster.MonsterService;
import com.revature.nutritioknights.userinfo.UserInfoService;
import com.revature.nutritioknights.util.annotations.Inject;
import com.revature.nutritioknights.util.custom_exceptions.InvalidRequestException;
import com.revature.nutritioknights.util.custom_exceptions.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class FightService {

    @Inject
    private final FightRepository fightRepository;
    private final AvatarService avatarService;
    private final MonsterService  monsterService;
    private final LevelService levelService;
    private final UserInfoService userInfoService;

    @Inject
    @Autowired
    public FightService(FightRepository fightRepository, AvatarService avatarService, MonsterService monsterService, LevelService levelService, UserInfoService userInfoService) {
        this.fightRepository = fightRepository;
        this.avatarService = avatarService;
        this.monsterService = monsterService;
        this.levelService = levelService;
        this.userInfoService = userInfoService;
    }

    public String newFight(NewFightRequest request){
        Fight newFight = new Fight();

        System.out.println("here");
        System.out.println(request.getMonster_id());
        System.out.println(request.getUsername());
        newFight.setMonster_id(monsterService.getMonsterByID(request.getMonster_id()));
        newFight.setUsername(avatarService.getByUsername(request.getUsername()).get());

        System.out.println("here2");
        System.out.println(newFight.getUsername().getLevel().getAttackPower());

        if(hasActiveFight(request.getUsername()))throw new ResourceConflictException("You cannot have more than 1 fight");

        newFight.setId(UUID.randomUUID().toString());

        newFight.setFight_monster_hp(newFight.getMonster_id().getMonster_max_hp());
        newFight.setFight_avatar_hp(levelService.getByLevel(avatarService.getByUsername(request.getUsername()).get().getLevel().getLevel()).getMax_hp());
        newFight.setFight_avatar_hp(newFight.getUsername().getLevel().getMax_hp());

        newFight.setLastChecked(new Date().getTime()/(1000*60*60*24));

        //new Monster no attack
        newFight.setMonster_hits(0);

        newFight.setActive(true);

        fightRepository.save(newFight);

        return newFight.getId();

    }

    private boolean hasActiveFight(String username){
        return fightRepository.getAllActivityByUsername(username).contains(true);
    }

    public Optional<Fight> getCurrentFightByUsername(String username) {
        return fightRepository.getActiveByUsername(username);
    }

    public Optional<Fight> getCurrentFightById(String id) {
        return fightRepository.getActiveById(id);
    }

    public Fight update(Fight currentFight) {
        return fightRepository.save(currentFight);
    }

    public Optional<Fight> updatedFight(String username){
        Fight curFight = new Fight();
        try{
            curFight = getCurrentFightByUsername(username).get();
            long today  = new Date().getTime()/(1000*60*60*24);
            if(today != curFight.getLastChecked()){
                curFight.setMonster_hits((int)(curFight.getMonster_hits() + today - curFight.getLastChecked()));
                curFight.setLastChecked(today);
                return Optional.of(fightRepository.save(curFight));
            }

            }catch (NoSuchElementException e) {throw new InvalidRequestException("No fights");}

        return Optional.of(curFight);
    }

    public Optional<Fight> progressFight(String username){
        Fight curFight = new Fight();
        try{
            curFight = getCurrentFightByUsername(username).get();

            // if monster has hit it takes president
            if(curFight.getMonster_hits() > 0){
                // gets damage
                int monsterDamage = curFight.getMonster_id().getAttackPower();
                // subtract current health from damage
                int avatarHealth = curFight.getFight_avatar_hp() - monsterDamage;
                // case 1: hp < 0
                if(avatarHealth <= 0){
                    //-------------- User Death

                    // set curfight vars
                    curFight.setFight_avatar_hp(0);
                    curFight.setActive(false);

                    //persist to db

                    fightRepository.save(curFight);

                    // -------------- End of User Death
                }

                // case 2: hp > 0
                // subtrace monster hits by 1
                curFight.setMonster_hits(curFight.getMonster_hits()-1);
                // save userheath
                curFight.setFight_avatar_hp(avatarHealth);
                return Optional.of(fightRepository.save(curFight));

            } else if (avatarService.getByUsername(username).get().getAttacks() > 0){
                Avatar curAvatar = avatarService.getByUsername(username).get();
                // user attacks
                // gets damage
                int avatarDamage = levelService.getByLevel(curAvatar.getLevel().getLevel()).getAttackPower();
                // subtract current health from damage
                int monsterHealth = curFight.getFight_monster_hp()  - avatarDamage;
                // case 1: hp < 0
                if(monsterHealth <= 0){
                    //----------------- Monster Death

                    // set curfight vars
                    curFight.setFight_monster_hp(0);
                    curFight.setActive(false);

                    // give reward to users
                    curAvatar.setXp(curAvatar.getXp() + curFight.getMonster_id().getXp_given());
                    while(avatarService.checkIfLevelUp(curAvatar)){
                        // up cur avatar level
                        curAvatar.setLevel(levelService.getByLevel(curAvatar.getLevel().getLevel() + 1));
                    }

                    // persist data

                    avatarService.update(curAvatar);

                    return Optional.of(fightRepository.save(curFight));
                    // ----------------- Monster Death End
                }
                // case 2: hp > 0
                // subtrace 1 hit from attack
                curAvatar.setAttacks(curAvatar.getAttacks() -1);

                // save monsterhealth
                curFight.setFight_monster_hp(monsterHealth);

                // save results
                avatarService.update(curAvatar);

                return Optional.of(fightRepository.save(curFight));

            }else{
                // do nothing
            }
        }catch (NoSuchElementException e) {throw new InvalidRequestException("No fights");}

        return Optional.of(curFight);
    }
}
