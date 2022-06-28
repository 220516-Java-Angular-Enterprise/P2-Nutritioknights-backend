package com.revature.nutritioknights.foodentry;

import com.fatsecret.platform.model.Food;
import com.revature.nutritioknights.fight.FightService;
import com.revature.nutritioknights.foodentry.dtos.GetByDateRequest;
import com.revature.nutritioknights.foodentry.dtos.GetByMealnameRequest;
import com.revature.nutritioknights.foodentry.dtos.NewFoodEntryRequest;
import com.revature.nutritioknights.util.annotations.Inject;
import com.revature.nutritioknights.util.custom_exceptions.InvalidRequestException;
import com.revature.nutritioknights.util.custom_exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class FoodEntryController {
    @Inject
    private final FoodEntryService foodEntryService;

    @Inject
    @Autowired
    public FoodEntryController(FoodEntryService foodEntryService) {this.foodEntryService = foodEntryService;
    }
    @CrossOrigin
    @GetMapping(value = "/id={id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody FoodEntry getEntry(@PathVariable String id) {
        return foodEntryService.getById(id);
    }
    @CrossOrigin
    @GetMapping(value = "/u={username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Date> getActivity(@PathVariable String username) {
        return foodEntryService.getActivity(username);
    }
    @CrossOrigin
    @GetMapping(value = "/d={date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FoodEntry> getUserEntriesByDate(@PathVariable Long date, @RequestBody GetByDateRequest request) {
        request.setDateInt(date);
        return foodEntryService.getUserEntriesByDate(request);
    }
    @CrossOrigin
    @GetMapping(value = "/suggest/{mealname_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FoodEntry> getUserEntriesByMealname(@PathVariable int mealname_id, @RequestBody GetByMealnameRequest request) {
        request.setMealnameId(mealname_id);
        //if returns null, don't throw an exception - we just don't need to display anything..
        return foodEntryService.getUserEntriesByMealname(request);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String newEntry(@RequestBody NewFoodEntryRequest request) {
        return foodEntryService.newEntry(request);
    }
    @CrossOrigin
    @DeleteMapping(value = "/{target}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void deleteEntry(@PathVariable String target){
        foodEntryService.deleteEntry(target);
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
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody Map<String, Object> handleInvalidRequestException(InvalidRequestException e){
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("status", 400);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now().toString());
        return responseBody;
    }
}
