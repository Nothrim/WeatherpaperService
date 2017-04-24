package com.nothrim.database.repositories.security;

import com.nothrim.database.models.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Notrim on 24.04.2017.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}