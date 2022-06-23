package com.revature.nutritioknights.food;

import com.fatsecret.platform.model.Food;
import com.revature.nutritioknights.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/foods")
public class FoodController {

    @Inject
    private final FoodService foodService;

    @Inject
    @Autowired
    public FoodController (FoodService foodService){this.foodService = foodService;};


}
