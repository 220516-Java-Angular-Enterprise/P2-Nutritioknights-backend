package com.revature.nutritioknights.login;

import com.revature.nutritioknights.auth.TokenService;
import com.revature.nutritioknights.login.dtos.requests.LoginRequest;
import com.revature.nutritioknights.login.dtos.responses.Principal;
import com.revature.nutritioknights.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Inject
    private final TokenService tokenService;
    private final UserCredService userCredService;

    @Inject
    @Autowired
    public LoginController(TokenService tokenService, UserCredService userCredService) {
        this.tokenService = tokenService;
        this.userCredService = userCredService;
    }

    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Principal login(@RequestBody LoginRequest request, HttpServletResponse resp){
        Principal principal = new Principal(userCredService.login(request));
        String token = tokenService.generateToken(principal);
        resp.setHeader("Authorization", token);
        return principal;
    }
}
