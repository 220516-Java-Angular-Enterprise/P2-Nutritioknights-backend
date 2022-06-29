package com.revature.nutritioknights.avatar;

import com.revature.nutritioknights.avatar.dtos.requests.NewAvatarRequest;
import com.revature.nutritioknights.avatar.dtos.requests.UpdateAvatarRequest;
import com.revature.nutritioknights.userinfo.UserInfo;
import com.revature.nutritioknights.userinfo.dtos.requests.UpdateUserRequest;
import com.revature.nutritioknights.util.annotations.Inject;
import com.revature.nutritioknights.util.custom_exceptions.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/avatar")
public class AvatarController {

    @Inject
    private final AvatarService avatarService;

    @Inject
    @Autowired
    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String register(@RequestBody NewAvatarRequest request) {
        return avatarService.register(request);
    }

    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, params = {"u"})
    public @ResponseBody Optional<Avatar> getAvatarByUsername(@RequestParam String u) {
        return avatarService.getByUsername(u);
    }

    @CrossOrigin
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, params = {"u"})
    public @ResponseBody Optional<Avatar> updateAvatarByUsername(@RequestParam String u, @RequestBody UpdateAvatarRequest request) {
        Avatar avatar = avatarService.getByUsername(u).get();
        avatar.setGender(request.getGender());
        return Optional.of(avatarService.update(avatar));
    }

    // ------------------------- EXCEPTION HANDELING

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody Map<String, Object> handleResourceConflictException(ResourceConflictException e){
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("status", 409);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now().toString());
        return responseBody;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody Map<String, Object> handleNoSuchElementException(NoSuchElementException e){
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("status", 404);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now().toString());
        return responseBody;
    }




}
