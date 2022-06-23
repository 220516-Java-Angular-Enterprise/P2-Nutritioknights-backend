package com.revature.nutritioknights.avatar;

import com.revature.nutritioknights.avatar.dtos.requests.NewAvatarRequest;
import com.revature.nutritioknights.userinfo.UserInfoService;
import com.revature.nutritioknights.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AvatarService {

    @Inject
    private final AvatarRepository avatarRepository;
    private final UserInfoService userInfoService;

    @Inject
    @Autowired
    public AvatarService(AvatarRepository avatarRepository, UserInfoService userInfoService) {
        this.avatarRepository = avatarRepository;
        this.userInfoService = userInfoService;
    }

    public String register(NewAvatarRequest request) {
        Avatar avatar = new Avatar(request);

        // Users must already have a diet plan to make avatar
        avatar.setDietPlan_id(userInfoService.getInfoByUsername(request.getUsername()).getDietPlan_id());

        // New Account starts with 10 strikes
        avatar.setAttacks(10);

        // New Account  starts at 0 xp
        avatar.setXp(0);

        // New accounts start on level 1
        avatar.setLevel(1);

        avatarRepository.save(avatar);

        return avatar.getUsername();

    }

    public Avatar getByUsername(String username){
        return avatarRepository.getByUsername(username);

    }
}
