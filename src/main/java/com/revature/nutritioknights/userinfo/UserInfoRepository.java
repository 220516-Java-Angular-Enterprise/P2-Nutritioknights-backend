package com.revature.nutritioknights.userinfo;

import com.revature.nutritioknights.login.UserCred;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo, String> {

    @Query(value = "SELECT * FROM usersinfo WHERE username = ?1", nativeQuery = true)
    UserInfo getByUsername(String username);

}
