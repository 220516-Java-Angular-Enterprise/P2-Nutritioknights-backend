package com.revature.nutritioknights.food;

import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.model.Food;
import com.fatsecret.platform.services.FatsecretService;
import com.fatsecret.platform.services.Response;
import com.revature.nutritioknights.util.annotations.Inject;
import com.revature.nutritioknights.util.custom_exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
Note: this class utilizes the fatsecret4j library for its food items.  This service talks to a FatsecretService objects
*/
@Service
public class FoodService extends FatsecretService {


    public FoodService(){
        super("c0ae9b9890b142399dc76aa946f0cf72", "9b86932a34174edbacc079bff25fbf31");
    }



    public Food getById(long id) {
        try {
            return super.getFood(id);
        } catch (NullPointerException e){
            throw new NotFoundException("Could not find a food with that ID.");
        }
    }
    public Response<CompactFood> searchFood(String query) {
        return super.searchFoods(query);
    }
}
