package com.revature.nutritioknights.food;

import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.model.Food;
import com.fatsecret.platform.services.FatsecretService;
import com.fatsecret.platform.services.Response;
import com.revature.nutritioknights.util.annotations.Inject;
import com.revature.nutritioknights.util.custom_exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/*
Note: this class utilizes the fatsecret4j library for its food items.  This service talks to a FatsecretService objects
*/
@Service
@Transactional
public class FoodService extends FatsecretService {


    public FoodService(){
        super("c0ae9b9890b142399dc76aa946f0cf72", "9b86932a34174edbacc079bff25fbf31");
    }



    public Food getById(long id) {
        Food food = super.getFood(id);
        if (food == null) {
            throw new NotFoundException("Could not retrieve a food with that ID.");
        }
        return food;
    }
    public Response<CompactFood> searchFood(String query) {
        Response<CompactFood> response = super.searchFoods(query);
        if (response == null) {
            throw new NotFoundException("This search result does not have that many pages.");
        }
        return response;
    }
    public Response<CompactFood> searchFood(String query, int page) {
        return super.searchFoods(query, page);
    }
}
