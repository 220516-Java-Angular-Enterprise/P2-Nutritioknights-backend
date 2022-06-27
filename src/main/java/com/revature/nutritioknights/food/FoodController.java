package com.revature.nutritioknights.food;

import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.model.Food;
import com.fatsecret.platform.services.Response;
import com.revature.nutritioknights.avatar.Avatar;
import com.revature.nutritioknights.util.annotations.Inject;
import com.revature.nutritioknights.util.custom_exceptions.InvalidRequestException;
import com.revature.nutritioknights.util.custom_exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/foods")
public class FoodController {

    @Inject
    private final FoodService foodService;

    @Inject
    @Autowired
    public FoodController (FoodService foodService){this.foodService = foodService;};
    @CrossOrigin
    @GetMapping(value = "/{food_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Food getById(@PathVariable Long food_id) {
        return foodService.getById(food_id);
    }
    @CrossOrigin
    @GetMapping(value = "/search/{query}", produces = MediaType.APPLICATION_JSON_VALUE)
    //note this Response object is a Response as defined in the fatsecret library
    public @ResponseBody Response<CompactFood> searchFood(@PathVariable String query) {
        return foodService.searchFood(query);
    }
    @CrossOrigin
    @GetMapping(value = "/search/{query}/p={page}", produces = MediaType.APPLICATION_JSON_VALUE)
    //note this Response object is a Response as defined in the fatsecret library
    public @ResponseBody Response<CompactFood> searchFood(@PathVariable String query, int page) {
        return foodService.searchFood(query,page);
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody Map<String, Object> handleNotFoundException(NotFoundException e){
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("status", 404);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now().toString());
        return responseBody;
    }
}
