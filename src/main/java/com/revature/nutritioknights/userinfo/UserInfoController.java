package com.revature.nutritioknights.userinfo;

import com.revature.nutritioknights.avatar.Avatar;
import com.revature.nutritioknights.fight.Fight;
import com.revature.nutritioknights.userinfo.dtos.requests.NewUserInfoRequest;
import com.revature.nutritioknights.userinfo.dtos.requests.UpdateUserRequest;
import com.revature.nutritioknights.util.annotations.Inject;
import com.revature.nutritioknights.util.custom_exceptions.InvalidRequestException;
import com.revature.nutritioknights.util.custom_exceptions.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

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

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String register(@RequestBody NewUserInfoRequest request) {
        return userInfoService.newUser(request).getUsername();
    }

    @CrossOrigin
    @GetMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<UserInfo> getInfoByUsername(@PathVariable String username) {
        return userInfoService.getInfoByUsername(username);
    }

    @CrossOrigin
    @PutMapping(value = "/update&{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<UserInfo> updateInfoByUsername(@PathVariable String username, @RequestBody UpdateUserRequest request) {
        UserInfo userInfo = userInfoService.getInfoByUsername(username).get();
        UserInfo updatedInfo = new UserInfo(request);
        updatedInfo.setUsername(userInfo.getUsername());
        updatedInfo.setEmail(userInfo.getEmail());
        return Optional.of(userInfoService.update(updatedInfo));
    }


    // ------------------------- EXCEPTION HANDELING


    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody Map<String, Object> handleInvalidRequestException(InvalidRequestException e){
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("status", 404);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now().toString());
        return responseBody;
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody Map<String, Object> handleResourceConflictException(ResourceConflictException e){
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("status", 409);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now().toString());
        return responseBody;
    }

}
