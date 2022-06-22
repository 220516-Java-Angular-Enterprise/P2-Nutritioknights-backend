package com.revature.nutritioknights.userinfo;

import com.revature.nutritioknights.userinfo.dtos.requests.NewUserInfoRequest;
import com.revature.nutritioknights.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserInfoService {

    @Inject
    private final UserInfoRepository userInfoRepository;

    @Inject
    @Autowired
    public UserInfoService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public UserInfo newUser(NewUserInfoRequest request){

        UserInfo userInfo = new UserInfo(request);
        userInfoRepository.save(userInfo);
        return userInfo;
    }

    // get all usernames
}
