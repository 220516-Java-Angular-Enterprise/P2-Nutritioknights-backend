package com.revature.nutritioknights.fight;

import com.revature.nutritioknights.avatar.AvatarService;
import com.revature.nutritioknights.fight.dtos.requests.NewFightRequest;
import com.revature.nutritioknights.level.LevelService;
import com.revature.nutritioknights.monster.MonsterService;
import com.revature.nutritioknights.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class FightService {

    @Inject
    private final FightRepository fightRepository;
    private final AvatarService avatarService;
    private final MonsterService  monsterService;
    private final LevelService levelService;

    @Inject
    @Autowired
    public FightService(FightRepository fightRepository, AvatarService avatarService, MonsterService monsterService, LevelService levelService) {
        this.fightRepository = fightRepository;
        this.avatarService = avatarService;
        this.monsterService = monsterService;
        this.levelService = levelService;
    }

    public String newFight(NewFightRequest request){
        Fight newFight = new Fight(request);

        newFight.setId(UUID.randomUUID().toString());

        newFight.setFight_monster_hp(monsterService.getMonsterByID(request.getMonster_id()).getMonster_max_hp());
        newFight.setFight_avatar_hp(levelService.getByLevel(avatarService.getByUsername(request.getUsername()).getLevel()).getMax_hp());

        //new Monster no attack
        newFight.setMonster_hits(0);

        newFight.setActive(true);

        fightRepository.save(newFight);

        return newFight.getId();

    }
}
