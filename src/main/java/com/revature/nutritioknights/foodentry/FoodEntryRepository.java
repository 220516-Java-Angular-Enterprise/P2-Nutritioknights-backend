package com.revature.nutritioknights.foodentry;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodEntryRepository  extends CrudRepository<FoodEntry,String> {

@Query(value ="SELECT * FROM food_entries where dateInt = ?1 and username = ?2", nativeQuery =true)
List<FoodEntry> getAllByDateIntAndUsername(long dateInt, String username);

@Query(value = "Select * FROM food_entries where username = ?1 and mealname = ?2", nativeQuery=true)
    List<FoodEntry> getAllByMealnameIdAndUsername(int mealname_id,String username);


}
