package com.revature.nutritioknights.monster;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MonsterRepository extends CrudRepository<Monster, String> {

    @Query(value = "SELECT * FROM monsters WHERE id = ?1", nativeQuery = true)
    Monster getById(String id);

    @Query(value = "SELECT * FROM monsters", nativeQuery = true)
    Optional<List<Monster>> getAll();
}
