package com.revature.nutritioknights.meals;

import com.revature.nutritioknights.login.UserCred;
import com.revature.nutritioknights.login.UserCredRepository;
import com.revature.nutritioknights.login.dtos.requests.LoginRequest;
import com.revature.nutritioknights.signup.dtos.requests.NewCredRequest;
import com.revature.nutritioknights.util.annotations.Inject;
import com.revature.nutritioknights.util.custom_exceptions.InvalidAuthenticationException;
import com.revature.nutritioknights.util.custom_exceptions.InvalidRequestException;
import com.revature.nutritioknights.util.custom_exceptions.NotAuthorizedException;
import com.revature.nutritioknights.util.custom_exceptions.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class MealsService {

}
