package com.revature.nutritioknights.foodentry;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodEntryRepository  extends CrudRepository<FoodEntry,String> {

    @Query(value ="SELECT * FROM food_entries where date_int = ?1 and username = ?2", nativeQuery =true)
    List<FoodEntry> getAllByDateIntAndUsername(long dateInt, String username);

    @Query(value = "SELECT * FROM food_entries where username = ?2 and mealname_id = ?1", nativeQuery=true)
    List<FoodEntry> getAllByMealnameIdAndUsername(int mealname_id,String username);
    @Query(value = "SELECT distinct(dateInt) FROM food_entries WHERE username = ?1", nativeQuery=true)
    List<Long> getDateintsByUsername(String username);

}
