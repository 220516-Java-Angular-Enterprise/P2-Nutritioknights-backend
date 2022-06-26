package com.revature.nutritioknights.foodentry;

import com.fatsecret.platform.model.Food;
import com.revature.nutritioknights.fight.FightService;
import com.revature.nutritioknights.foodentry.dtos.GetByDateRequest;
import com.revature.nutritioknights.foodentry.dtos.GetByMealnameRequest;
import com.revature.nutritioknights.foodentry.dtos.NewFoodEntryRequest;
import com.revature.nutritioknights.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class FoodEntryController {
    @Inject
    private final FoodEntryService foodEntryService;

    @Inject
    @Autowired
    public FoodEntryController(FoodEntryService foodEntryService) {this.foodEntryService = foodEntryService;
    }

    @GetMapping(value = "/{user}}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Long> getActivity(@PathVariable String user) {
    }
    @GetMapping(value = "/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FoodEntry> getUserEntriesByDate(@PathVariable Long date, @RequestBody GetByDateRequest request) {
    }
    @GetMapping(value = "/suggest/{mealname_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FoodEntry> getUserEntriesByMealname(@PathVariable int mealname_id, @RequestBody GetByMealnameRequest request) {
        request.setMealnameId(mealname_id);
        return foodEntryService.getUserEntriesByMealname(request);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String newEntry(@RequestBody NewFoodEntryRequest request) {
        return foodEntryService.newEntry(request);
    }

}
