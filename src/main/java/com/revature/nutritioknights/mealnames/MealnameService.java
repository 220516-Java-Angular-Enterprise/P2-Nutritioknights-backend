package com.revature.nutritioknights.mealnames;

import com.revature.nutritioknights.foodentry.FoodEntry;
import com.revature.nutritioknights.foodentry.FoodEntryRepository;
import com.revature.nutritioknights.foodentry.dtos.GetByDateRequest;
import com.revature.nutritioknights.foodentry.dtos.GetByMealnameRequest;
import com.revature.nutritioknights.foodentry.dtos.NewFoodEntryRequest;
import com.revature.nutritioknights.util.annotations.Inject;
import com.revature.nutritioknights.util.custom_exceptions.InvalidRequestException;
import com.revature.nutritioknights.util.custom_exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class MealnameService {

    @Inject
    private final MealnameRepository mealnameRepository;
    @Inject
    @Autowired
    public MealnameService(MealnameRepository mealnameRepository){
        this.mealnameRepository=mealnameRepository;
    }

}
