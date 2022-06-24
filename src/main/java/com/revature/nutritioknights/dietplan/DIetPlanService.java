package com.revature.nutritioknights.dietplan;

import com.revature.nutritioknights.monster.Monster;
import com.revature.nutritioknights.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DIetPlanService {

    @Inject
    private final DietPlanRepository dietPlanRepository;

    @Inject
    @Autowired
    public DIetPlanService(DietPlanRepository dietPlanRepository) {
        this.dietPlanRepository = dietPlanRepository;
    }

    public Monster getMonsterByID(String id){
        return dietPlanRepository.getById(id);
    }
}
