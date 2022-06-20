package com.revature.nutritioknights.login;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCredRepository extends CrudRepository<UserCred, String> {
    @Modifying
    @Query(value = "INSERT INTO logins (id, username, password, email, role) VALUES (?1, ?2, crypt(?3, gen_salt('bf')), ?4, ?5)", nativeQuery = true)
    void saveUser(String id, String username, String password, String email, String role);

    @Query(value = "SELECT username FROM logins", nativeQuery = true)
    List<String> getAllUsername();

    @Query(value = "SELECT * FROM logins WHERE username = ?1 AND password = crypt(?2, password)", nativeQuery = true)
    UserCred getUserByUsernameAndPassword(String username, String password);

}
