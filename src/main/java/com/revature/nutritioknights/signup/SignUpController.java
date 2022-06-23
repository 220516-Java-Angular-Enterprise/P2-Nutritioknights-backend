/*package com.revature.nutritioknights.signup;

import com.revature.nutritioknights.login.UserCredService;
import com.revature.nutritioknights.signup.dtos.requests.NewCredRequest;
import com.revature.nutritioknights.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignUpController {

    @Inject
    private final UserCredService userCredService;

    @Inject
    @Autowired
    public SignUpController(UserCredService userCredService) {
        this.userCredService = userCredService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String register(@RequestBody NewCredRequest request) {
        request.setRole("DEFAULT");
        return userCredService.register(request).getId();
    }
}*/
