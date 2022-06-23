package com.revature.nutritioknights.avatar;

import com.revature.nutritioknights.avatar.dtos.requests.NewAvatarRequest;
import com.revature.nutritioknights.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String register(@RequestBody NewAvatarRequest request) {
        return avatarService.register(request);
    }

}
