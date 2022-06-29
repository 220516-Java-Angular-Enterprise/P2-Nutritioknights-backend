package com.revature.nutritioknights.monster;

import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.services.Response;
import com.revature.nutritioknights.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/monsters")
public class MonsterController {

    @Inject
    private final MonsterService monsterService;

    @Inject
    @Autowired
    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    //note this Response object is a Response as defined in the fatsecret library
    public @ResponseBody Optional<List<Monster>> getAllMonsters() {
        return monsterService.getAllMonsters();
    }

}
