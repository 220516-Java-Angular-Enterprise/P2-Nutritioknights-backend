package com.revature.nutritioknights.level;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LevelRepository extends CrudRepository<Level,String> {

    @Query(value = "SELECT * FROM levels WHERE level = ?1", nativeQuery = true)
    Level getByLevel(int level);
}
