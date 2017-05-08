package com.nothrim.database.repositories.images;

import com.nothrim.database.models.images.ApiCall;
import com.nothrim.database.models.images.Image;
import com.nothrim.database.models.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * Created by Notrim on 24.04.2017.
 */
public interface ImageRepository extends JpaRepository<Image, Long> {
    Set<Image> findAllByApiCallAndUsersNotIn(ApiCall apiCall, Set<User> users);
}