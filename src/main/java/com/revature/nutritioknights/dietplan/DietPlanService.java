package com.revature.nutritioknights.dietplan;

import com.revature.nutritioknights.monster.Monster;
import com.revature.nutritioknights.util.annotations.Inject;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class DietPlanService {

    @Inject
    private final DietPlanRepository dietPlanRepository;

    public DietPlanService(DietPlanRepository dietPlanRepository) {
        this.dietPlanRepository = dietPlanRepository;
    }

    public Optional<DietPlan> getDietPlanByID(String id){
        return dietPlanRepository.getById(id);
    }
}
