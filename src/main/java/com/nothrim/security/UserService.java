package com.nothrim.security;

import com.nothrim.database.models.security.User;

/**
 * Created by Notrim on 24.04.2017.
 */
public interface UserService {
    public void save(User user);
    public User findByUsername(String username);
}
