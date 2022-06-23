package com.revature.nutritioknights.auth.foodentry;

import com.fatsecret.platform.services.FatsecretService;
import com.revature.nutritioknights.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FoodEntryService {

    @Inject
    private final FoodEntryRepository foodEntryRepository;
    private final FatsecretService fatsecretService;

    @Inject
    @Autowired
    public FoodEntryService (FoodEntryRepository foodEntryRepository){
        this.foodEntryRepository=foodEntryRepository;
        //we don't actually persist any food items, only their ids.  So food is handled within food_entries via the modified fatsecret4j library.
        this.fatsecretService=new FatsecretService("c0ae9b9890b142399dc76aa946f0cf72", "9b86932a34174edbacc079bff25fbf31");
    }

    //todo: methods: addEntry, searchFoods, (recipes??), getFoodById

}
