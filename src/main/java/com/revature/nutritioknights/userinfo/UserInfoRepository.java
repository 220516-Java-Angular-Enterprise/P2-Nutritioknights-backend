package com.revature.nutritioknights.userinfo;

import com.revature.nutritioknights.login.UserCred;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserInfoRepository extends CrudRepository<UserInfo, String> {

    @Query(value = "SELECT * FROM usersinfo WHERE username = ?1", nativeQuery = true)
    Optional<UserInfo> getByUsername(String username);

    @Query(value = "SELECT * FROM usersinfo WHERE email = ?1", nativeQuery = true)
    Optional<UserInfo> getByEmail(String email);

    @Query(value = "SELECT * FROM usersinfo", nativeQuery = true)
    List<UserInfo> getAllUsers();

    @Query(value = "SELECT username FROM usersinfo", nativeQuery = true)
    List<String> getAllUsername();

    @Query(value = "SELECT email FROM usersinfo", nativeQuery = true)
    Optional<String> getAllEmail();
}
