package com.revature.nutritioknights.fight;

import com.revature.nutritioknights.fight.dtos.requests.AddMonsterHitsById;
import com.revature.nutritioknights.fight.dtos.requests.NewFightRequest;
import com.revature.nutritioknights.util.annotations.Inject;
import com.revature.nutritioknights.util.custom_exceptions.InvalidRequestException;
import com.revature.nutritioknights.util.custom_exceptions.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

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

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String newFight(@RequestBody NewFightRequest request) {
        return fightService.newFight(request);
    }

    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, params = {"u"})
    public @ResponseBody Optional<Fight> getFightById(@RequestParam String u) {
        return fightService.getCurrentFightById(u);}

    @CrossOrigin
    @GetMapping(value = "/history", produces = MediaType.APPLICATION_JSON_VALUE, params = {"u"})
    public @ResponseBody Optional<List<Fight>> getHistory(@RequestParam String u) {
        return fightService.getHistoryOfUser(u);}




    @CrossOrigin
    @PutMapping(value = "/{id}/add-mh",consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Fight addMonsterHits(@PathVariable String id, @RequestBody AddMonsterHitsById request) {
        Fight currentFight = new Fight();
        try {
            currentFight = fightService.getCurrentFightById(id).get();
            currentFight.setMonster_hits(request.getMonster_hits());
            return fightService.update(currentFight);
        }catch (NoSuchElementException e){
            throw new InvalidRequestException("No Fight by that Id");
        }
    }

    @CrossOrigin
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, params = {"u"})
    public @ResponseBody Optional<Fight> getCurrentFightByUsername(@RequestParam String u) {
        return fightService.updatedFight(u);
    }

    @CrossOrigin
    @PutMapping(value = "/history", produces = MediaType.APPLICATION_JSON_VALUE, params = {"u"})
    public @ResponseBody Optional<Fight> getHistoryFightByUsername(@RequestParam String username) {
        return fightService.updatedFight(username);
    }

    // progression of fight
    @CrossOrigin
    @PutMapping(value = "/progress", produces = MediaType.APPLICATION_JSON_VALUE, params = {"u"})
    public @ResponseBody Optional<Fight> progressFight(@RequestParam String username) {
        return fightService.progressFight(username);
    }

    // ------------------------- EXCEPTION HANDELING

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody Map<String, Object> handleResourceConflictException(ResourceConflictException e){
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("status", 409);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now().toString());
        return responseBody;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody Map<String, Object> handleInvalidRequestException(InvalidRequestException e){
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("status", 404);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now().toString());
        return responseBody;
    }

}
