package com.revature.nutritioknights.fight;

import com.revature.nutritioknights.fight.dtos.requests.NewFightRequest;
import com.revature.nutritioknights.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fight")
public class FightController {

    @Inject
    private final FightService fightService;

    @Inject
    @Autowired
    public FightController(FightService fightService) {
        this.fightService = fightService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String newFight(@RequestBody NewFightRequest request) {
        return fightService.newFight(request);
    }

}
