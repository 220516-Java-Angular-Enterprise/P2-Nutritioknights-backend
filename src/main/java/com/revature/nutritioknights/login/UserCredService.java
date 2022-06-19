package com.revature.nutritioknights.login;

import com.revature.nutritioknights.login.dtos.requests.LoginRequest;
import com.revature.nutritioknights.util.annotations.Inject;
import com.revature.nutritioknights.util.custom_exceptions.InvalidAuthenticationException;
import com.revature.nutritioknights.util.custom_exceptions.NotAuthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserCredService {

    @Inject
    private final UserCredRepository userCredRepository;

    @Inject
    @Autowired
    public UserCredService(UserCredRepository userCredRepository) {
        this.userCredRepository = userCredRepository;
    }

    public UserCred login(LoginRequest request) {
        UserCred user =  userCredRepository.getUserByUsernameAndPassword(request.getUsername(), request.getPassword());
        if (isValidInfo(user) &&  !user.getRole().equals("BANNED")){
            return user;
        } else if (user == null){
            throw new InvalidAuthenticationException("Invalid credentials");
        }else{
            throw new NotAuthorizedException("Not allowed to login");
        }
    }
    private boolean isValidInfo(UserCred user) {
        if(user == null) return false;
        return true;
    }
}
