package com.revature.nutritioknights.userinfo;

import com.revature.nutritioknights.userinfo.dtos.requests.NewUserInfoRequest;
import com.revature.nutritioknights.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @Inject
    private final UserInfoService userInfoService;

    @Inject
    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String register(@RequestBody NewUserInfoRequest request) {
        return userInfoService.newUser(request).getUsername();
    }

}
