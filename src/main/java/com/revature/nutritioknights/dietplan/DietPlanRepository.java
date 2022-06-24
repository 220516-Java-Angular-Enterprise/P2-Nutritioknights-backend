package com.revature.nutritioknights.dietplan;

import com.revature.nutritioknights.monster.Monster;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DietPlanRepository extends CrudRepository<Monster, String> {

    @Query(value = "SELECT * FROM dietplans WHERE id = ?1", nativeQuery = true)
    Monster getById(String id);
}
