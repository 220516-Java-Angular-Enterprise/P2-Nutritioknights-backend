package com.revature.nutritioknights.userinfo;

import com.revature.nutritioknights.dietplan.DietPlanService;
import com.revature.nutritioknights.userinfo.dtos.requests.NewUserInfoRequest;
import com.revature.nutritioknights.util.annotations.Inject;
import com.revature.nutritioknights.util.custom_exceptions.InvalidRequestException;
import com.revature.nutritioknights.util.custom_exceptions.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class UserInfoService {

    @Inject
    private final UserInfoRepository userInfoRepository;
    private final DietPlanService dietPlanService;

    @Inject
    @Autowired
    public UserInfoService(UserInfoRepository userInfoRepository, DietPlanService dietPlanService) {
        this.userInfoRepository = userInfoRepository;
        this.dietPlanService = dietPlanService;
    }

    public UserInfo newUser(NewUserInfoRequest request){

        // diet plan id request.getDietPlan_id();
        UserInfo userInfo = new UserInfo(request);

        try{
            userInfo.setDietPlan(dietPlanService.getDietPlanByID(request.getDietPlan_id()).get());
            validUser(userInfo);
            if(userExists(userInfo.getUsername())) throw new ResourceConflictException("Username exists");

            userInfoRepository.save(userInfo);
        }catch (InvalidRequestException e){
            throw new InvalidRequestException(e.getMessage());
        } catch (ResourceConflictException  e) {
            throw new ResourceConflictException(e.getMessage());
        }catch (NoSuchElementException e){
            throw new InvalidRequestException(e.getMessage());
        }catch (Exception e){
            throw new RuntimeException("Unexpected Error");
        }
        return userInfo;
    }

    public Optional<UserInfo> getInfoByUsername(String username) {
        return userInfoRepository.getByUsername(username);
    }

    // get all usernames
    public List<UserInfo> getAllUsers(){
        return userInfoRepository.getAllUsers();
    }

    private boolean userExists(String username){
        return userInfoRepository.getAllUsername().contains(username);
    }

    private boolean emailExists(String email){
        return userInfoRepository.getAllEmail().contains(email);
    }

    public boolean validUser(UserInfo user){
        if(user.getUsername() == null){throw new InvalidRequestException("Username is null");}
        if(user.getEmail() == null){throw new InvalidRequestException("Email is null");}
        if(user.getFname() == null){throw new InvalidRequestException("First Name is null");}
        if(user.getLname() == null){throw new InvalidRequestException("Last Name is null");}
        if(user.getAge() == 0){throw new InvalidRequestException("Age is null");}
        if(user.getSex() == null){throw new InvalidRequestException("Sex is null");}
        if(user.getHeight() == 0){throw new InvalidRequestException("Height is null");}
        if(user.getTargetCals() == 0){throw new InvalidRequestException("Target Cal is null");}
        if(user.getDietPlan() == null){throw new InvalidRequestException("Diet Plan is null");}
        if(user.getCurrentWeight() == 0){throw new InvalidRequestException("Current Weight is null");}
        return true;
    }

    public UserInfo update(UserInfo userInfo) {
        validUser(userInfo);
        return userInfoRepository.save(userInfo);
    }

}
