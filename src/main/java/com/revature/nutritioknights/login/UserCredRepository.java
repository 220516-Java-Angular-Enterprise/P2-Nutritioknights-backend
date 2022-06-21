package com.revature.nutritioknights.login;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCredRepository extends CrudRepository<UserCred, String> {
    @Modifying
    @Query(value = "INSERT INTO logins (id, email, password, role) VALUES (?1, ?2, crypt(?3, gen_salt('bf')), ?4)", nativeQuery = true)
    void saveUser(String id, String email, String password,  String role);

    @Query(value = "SELECT email FROM logins", nativeQuery = true)
    List<String> getAllEmails();

    @Query(value = "SELECT * FROM logins WHERE email = cast(?1 AS text) AND password = crypt(?2, password)", nativeQuery = true)
    UserCred getUserByEmailAndPassword(String email, String password);

}
