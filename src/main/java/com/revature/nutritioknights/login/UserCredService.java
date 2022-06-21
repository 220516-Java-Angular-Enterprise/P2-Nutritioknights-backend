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
        UserCred user =  userCredRepository.getUserByEmailAndPassword(request.getEmail(), request.getPassword());
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
        String email = user.getEmail();
        if (isUniqueUsername(email)){
                if(isValidPassword(user.getPassword())){
                    user.setId(UUID.randomUUID().toString());
                    userCredRepository.saveUser(user.getId(), user.getEmail(),user.getPassword(), user.getRole());
                } else throw new InvalidRequestException("Invalid password. Minimum eight characters, at least one letter, one number and one special character.");
        } else throw new ResourceConflictException("Email is already taken :(");

        return user;
    }

    private List<String> getAllUserNames(){
        return userCredRepository.getAllEmails();
    }

    private boolean isUniqueUsername(String email) {
        List<String> emails = userCredRepository.getAllEmails();
        return !emails.contains(email);
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    }
}
