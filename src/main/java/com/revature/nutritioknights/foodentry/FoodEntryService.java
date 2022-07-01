package com.revature.nutritioknights.foodentry;

import com.fatsecret.platform.model.Food;
import com.fatsecret.platform.model.Serving;
import com.revature.nutritioknights.food.FoodService;
import com.revature.nutritioknights.foodentry.dtos.GetByDateRequest;
import com.revature.nutritioknights.foodentry.dtos.GetByMealnameRequest;
import com.revature.nutritioknights.foodentry.dtos.NewFoodEntryRequest;
import com.revature.nutritioknights.foodentry.dtos.response.FoodEntryPrettyResponse;
import com.revature.nutritioknights.util.annotations.Inject;
import com.revature.nutritioknights.util.custom_exceptions.InvalidRequestException;
import com.revature.nutritioknights.util.custom_exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional
public class FoodEntryService {

    @Inject
    private final FoodEntryRepository foodEntryRepository;
    private final FoodService foodService;
    @Inject
    @Autowired
    public FoodEntryService (FoodEntryRepository foodEntryRepository, FoodService foodService){
        this.foodEntryRepository=foodEntryRepository;
        this.foodService = foodService;
    }

    public String newEntry(NewFoodEntryRequest request){
        FoodEntry newFoodEntry = new FoodEntry(request);
        long dateInt = new Date().getTime()/(1000*60*60*24);
        newFoodEntry.setDateInt(dateInt);
        newFoodEntry.setEntry_id(UUID.randomUUID().toString());
        //input validation
        if (newFoodEntry.getServing_amt()<0){
            throw new InvalidRequestException ("You can't have negative serving sizes, unfortunately.");
        }
        if (newFoodEntry.getServing_amt()==0){
            throw new InvalidRequestException ("Having 0 servings of something is the same as not eating it, silly!");
        }
        foodEntryRepository.save(newFoodEntry);
        return newFoodEntry.getEntry_id();
    }

    public List<FoodEntry> getUserEntriesByDate(GetByDateRequest request){
        List<FoodEntry> entryList = foodEntryRepository.getAllByDateIntAndUsername(request.getDateInt(),request.getUsername());
        if (entryList.size()==0){
            throw new NotFoundException("No entries found for this combination of user and date.");
        }
        return entryList;
    }

    public List<FoodEntry> getUserEntriesByMealname(GetByMealnameRequest request){
        List<FoodEntry> entryList = foodEntryRepository.getAllByMealnameIdAndUsername(request.getMealnameId(),request.getUsername());
        if (request.getMealnameId()>6||request.getMealnameId()<1) {
            throw new InvalidRequestException("Invalid mealname id (must be 1-6).");
        }
        if (entryList.size()==0){
            throw new NotFoundException("No entries found for the selected combination of meal and date.");
        }
        return entryList;
    }
    public List<Date> getActivity(String username){
        List<Date> entryList= new ArrayList<Date>();
        foodEntryRepository.getDateintsByUsername(username).stream().forEach(i -> entryList.add(new Date(i*(1000*60*60*24))));
        if (entryList.size()==0){
            return null;
        }
        return entryList;
    }
    public void deleteEntry(String id){
        if (!(this.getById(id).getDateInt()==new Date().getTime()/(1000*60*60*24))) {
            throw new InvalidRequestException("You cannot delete entries from a previous date.");
        }
        foodEntryRepository.deleteById(id);
    }
    public FoodEntry getById(String id){
        try {
            return foodEntryRepository.findById(id).get();
        } catch (NoSuchElementException e){
            throw new NotFoundException("Could not find an entry with that ID");
        }
    }

    public List<FoodEntryPrettyResponse>  foodPretty(GetByDateRequest request){

        List<FoodEntry> entryList = foodEntryRepository.getAllByDateIntAndUsername(request.getDateInt(),request.getUsername());
        List<FoodEntryPrettyResponse> pretty = new ArrayList<>();
        Food food = new Food();
        Serving serving = new Serving();


        for(FoodEntry entry: entryList){
            food = this.foodService.getFood(entry.getFood_id());
            serving = getServingById(entry.getServing_id(),food.getServings());
            pretty.add(new FoodEntryPrettyResponse(entry.getEntry_id(),entry.getServing_amt(),food.getName(),entry.getServing_amt() * serving.getCalories().intValue(),  serving.getProtein().intValue()*entry.getServing_amt(), serving.getCarbohydrate().intValue()*entry.getServing_amt(), serving.getFat().intValue()*entry.getServing_amt(),entry.getFood_id(),entry.getServing_id()));
        }
        return pretty;
    }

    private Serving getServingById(long id, List<Serving> servings){
        for(Serving s: servings){
            if(id == s.getServingId()) {
                return s;
            }
        }
        return null;
    }
}
