package com.revature.nutritioknights.login;

import com.revature.nutritioknights.login.dtos.requests.LoginRequest;
import com.revature.nutritioknights.signup.dtos.requests.NewCredRequest;
import com.revature.nutritioknights.util.annotations.Inject;
import com.revature.nutritioknights.util.custom_exceptions.InvalidAuthenticationException;
import com.revature.nutritioknights.util.custom_exceptions.InvalidRequestException;
import com.revature.nutritioknights.util.custom_exceptions.NotAuthorizedException;
import com.revature.nutritioknights.util.custom_exceptions.ResourceConflictException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public UserCred register(NewCredRequest request){
        UserCred user = request.extractCred();
        String username = user.getUsername();
        if (isUniqueUsername(username)){
            if(isValidUsername(username)){
                if(isValidPassword(user.getPassword())){
                    user.setId(UUID.randomUUID().toString());
                    userCredRepository.saveUser(user.getId(), user.getUsername(),user.getPassword(),user.getEmail(),user.getRole());
                } else throw new InvalidRequestException("Invalid password. Minimum eight characters, at least one letter, one number and one special character.");
            } else throw new InvalidRequestException("Invalid username. Username needs to be 8-20 characters long.");
        } else throw new ResourceConflictException("Username is already taken :(");

        return user;
    }

    private List<String> getAllUserNames(){
        return userCredRepository.getAllUsername();
    }

    private boolean isUniqueUsername(String username) {
        List<String> usernames = getAllUserNames();
        return !usernames.contains(username);
    }

    private boolean isValidUsername(String username) {
        return username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    }
}
