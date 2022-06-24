package com.revature.nutritioknights.dietplan;

import com.revature.nutritioknights.monster.Monster;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DietPlanRepository extends CrudRepository<DietPlan, String> {

    @Query(value = "SELECT * FROM dietplans WHERE id = ?1", nativeQuery = true)
    Optional<DietPlan> getById(String id);
}
