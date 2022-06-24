package com.revature.nutritioknights.avatar;

import com.revature.nutritioknights.avatar.Avatar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AvatarRepository extends CrudRepository<Avatar, String> {

    @Query(value = "SELECT * FROM avatars WHERE username = ?1", nativeQuery = true)
    Avatar getByUsername(String id);

    @Query(value = "SELECT username FROM avatars", nativeQuery = true)
    List<String> getAllUsername();
}
