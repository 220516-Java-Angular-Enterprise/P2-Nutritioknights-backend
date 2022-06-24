package com.revature.nutritioknights.avatar;

import com.revature.nutritioknights.avatar.dtos.requests.NewAvatarRequest;
import com.revature.nutritioknights.dietplan.DietPlanService;
import com.revature.nutritioknights.level.LevelService;
import com.revature.nutritioknights.userinfo.UserInfoService;
import com.revature.nutritioknights.util.annotations.Inject;
import com.revature.nutritioknights.util.custom_exceptions.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AvatarService {

    @Inject
    private final AvatarRepository avatarRepository;
    private final UserInfoService userInfoService;
    private final LevelService levelService;
    private final DietPlanService dietPlanService;

    @Inject
    @Autowired
    public AvatarService(AvatarRepository avatarRepository, UserInfoService userInfoService, LevelService levelService, DietPlanService dietPlanService) {
        this.avatarRepository = avatarRepository;
        this.userInfoService = userInfoService;
        this.levelService = levelService;
        this.dietPlanService = dietPlanService;
    }

    public String register(NewAvatarRequest request) {
        Avatar avatar = new Avatar(request);

        System.out.println(request.getUsername());

        if(usernameExists(request.getUsername())) throw new ResourceConflictException("You already have an avatar");

        // Users must already have a diet plan to make avatar
        avatar.setDietPlan(dietPlanService.getDietPlanByID(userInfoService.getInfoByUsername(request.getUsername()).get().getDietPlan_id()).get());
        //avatar.setDietPlan(dietPlanService.getDietPlanByID("Balance").get());

        // New Account starts with 10 strikes
        avatar.setAttacks(10);

        // New Account  starts at 0 xp
        avatar.setXp(0);

        // New accounts start on level 1
        avatar.setLevel(levelService.getByLevel(1));

        avatarRepository.save(avatar);

        return avatar.getUsername();

    }

    public Optional<Avatar> getByUsername(String username){
        return avatarRepository.getByUsername(username);

    }

    private boolean usernameExists(String username){
        return avatarRepository.getAllUsername().contains(username);
    }

    public Avatar update(Avatar avatar){return avatarRepository.save(avatar);}

    public boolean checkIfLevelUp(Avatar curAvatar) {
        int curXP = curAvatar.getXp();
        int curLevel = curAvatar.getLevel().getLevel();

        // checks if cur xp is greater than level ceiling

        if(curXP > levelService.getByLevel(curLevel).getXp_ceiling()){

            return true;
        }
        return false;
    }
}
