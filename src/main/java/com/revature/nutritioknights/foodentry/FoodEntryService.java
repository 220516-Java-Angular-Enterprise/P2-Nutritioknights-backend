package com.revature.nutritioknights.foodentry;

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

    @Inject
    @Autowired
    public FoodEntryService (FoodEntryRepository foodEntryRepository){
        this.foodEntryRepository=foodEntryRepository;
        //we don't actually persist any food items, only their ids.  Use food

    }

    //todo: methods: addEntry, getEntryByID, getEntryByDate

}
