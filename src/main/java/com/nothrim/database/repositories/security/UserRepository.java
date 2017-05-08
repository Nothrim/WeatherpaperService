package com.nothrim.database.repositories.security;

import com.nothrim.database.models.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Notrim on 24.04.2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByToken(String token);
}
