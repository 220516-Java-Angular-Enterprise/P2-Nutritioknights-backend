package com.revature.nutritioknights.food;

import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.model.Food;
import com.fatsecret.platform.services.FatsecretService;
import com.fatsecret.platform.services.Response;
import com.revature.nutritioknights.util.annotations.Inject;
import org.springframework.stereotype.Service;

/*
Note: this class utilizes the fatsecret4j library for its food items.  This service talks to a FatsecretService object to return objects


*/
@Service
public class FoodService extends FatsecretService {


    public FoodService(){
        super("c0ae9b9890b142399dc76aa946f0cf72", "9b86932a34174edbacc079bff25fbf31");
    }

    //todo: getFoodById, searchFood.  use DTOs and feed the request objects into the fatsecretService methods.
}
