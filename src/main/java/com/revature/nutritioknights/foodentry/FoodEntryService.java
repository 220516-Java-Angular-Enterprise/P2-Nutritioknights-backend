package com.revature.nutritioknights.foodentry;

import com.fatsecret.platform.services.FatsecretService;
import com.revature.nutritioknights.foodentry.dtos.GetByDateRequest;
import com.revature.nutritioknights.foodentry.dtos.GetByMealnameRequest;
import com.revature.nutritioknights.foodentry.dtos.NewFoodEntryRequest;
import com.revature.nutritioknights.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class FoodEntryService {

    @Inject
    private final FoodEntryRepository foodEntryRepository;
    @Inject
    @Autowired
    public FoodEntryService (FoodEntryRepository foodEntryRepository){
        this.foodEntryRepository=foodEntryRepository;
        //we don't actually persist any food items, only their ids.

    }

    public String newEntry(NewFoodEntryRequest request){
        FoodEntry newFoodEntry = new FoodEntry(request);
        newFoodEntry.setDateInt(new Date().getTime()/(1000*60*60*24));
        newFoodEntry.setEntry_id(UUID.randomUUID().toString());
        foodEntryRepository.save(newFoodEntry);
        return newFoodEntry.getEntry_id();
    }

    public List<FoodEntry> getUserEntriesByDate(GetByDateRequest request){
        return foodEntryRepository.getAllByDateIntAndUsername(request.getDateInt(),request.getUsername());
    }

    public List<FoodEntry> getUserEntriesByMealname(GetByMealnameRequest request){
        return foodEntryRepository.getAllByMealnameIdAndUsername(request.getMealnameId(),request.getUsername());
    }
    public List<Long> getActivity(String username){
        return foodEntryRepository.getDateintsByUsername(username);
    }
}
