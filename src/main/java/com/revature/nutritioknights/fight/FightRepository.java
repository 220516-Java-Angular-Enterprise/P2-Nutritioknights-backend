package com.revature.nutritioknights.fight;

import com.revature.nutritioknights.fight.Fight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FightRepository extends CrudRepository<Fight, String> {

    @Query(value = "SELECT active FROM fights WHERE username = ?1", nativeQuery = true)
    List<Boolean> getAllActivityByUsername(String username);

    @Query(value = "SELECT * FROM fights WHERE username = ?1", nativeQuery = true)
    Optional<Fight> getActiveByUsername(String username);

    @Query(value = "SELECT * FROM fights WHERE id = ?1", nativeQuery = true)
    Optional<Fight> getActiveById(String id);
}
