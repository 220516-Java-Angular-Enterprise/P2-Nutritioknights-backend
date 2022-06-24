package com.revature.nutritioknights.avatar;

import com.revature.nutritioknights.avatar.Avatar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AvatarRepository extends CrudRepository<Avatar, String> {

    @Query(value = "SELECT * FROM avatars WHERE username = ?1", nativeQuery = true)
    Optional<Avatar> getByUsername(String id);

    @Query(value = "SELECT username FROM avatars", nativeQuery = true)
    List<String> getAllUsername();
}
