package com.revature.nutritioknights.avatar;

import com.revature.nutritioknights.avatar.Avatar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AvatarRepository extends CrudRepository<Avatar, String> {

    @Query(value = "SELECT * FROM avatars WHERE id = ?1", nativeQuery = true)
    Avatar getByUsername(String id);
}
