package com.revature.nutritioknights.foodentry;

import com.fatsecret.platform.model.Food;
import com.revature.nutritioknights.fight.FightService;
import com.revature.nutritioknights.foodentry.dtos.GetByDateRequest;
import com.revature.nutritioknights.foodentry.dtos.GetByMealnameRequest;
import com.revature.nutritioknights.foodentry.dtos.NewFoodEntryRequest;
import com.revature.nutritioknights.foodentry.dtos.response.FoodEntryPrettyResponse;
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
    @GetMapping(value = "/entry",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody FoodEntry getEntry(@RequestParam String id) {
        return foodEntryService.getById(id);
    }
    @CrossOrigin
    @GetMapping(value = "/activity",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Date> getActivity(@RequestParam String u) {
        return foodEntryService.getActivity(u);
    }
    @CrossOrigin
    @GetMapping(value = "/date",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FoodEntry> getUserEntriesByDate(@RequestParam Long d, String u) {
        return foodEntryService.getUserEntriesByDate(new GetByDateRequest(u,d));
    }

    @CrossOrigin
    @GetMapping(value = "/pretty",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FoodEntryPrettyResponse> getPretty(@RequestParam Long d, String u) {
        return this.foodEntryService.foodPretty(new GetByDateRequest(u,d));
    }

    @CrossOrigin
    @GetMapping(value = "/suggest",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FoodEntry> getUserEntriesByMealname(@RequestParam int m, String u) {
        return foodEntryService.getUserEntriesByMealname(new GetByMealnameRequest(m,u));
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String newEntry(@RequestBody NewFoodEntryRequest request) {
        return foodEntryService.newEntry(request);
    }
    @CrossOrigin
    @DeleteMapping(value = "{target}", produces = MediaType.APPLICATION_JSON_VALUE)
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
