package com.nothrim.security;

/**
 * Created by Notrim on 24.04.2017.
 */
public interface SecurityService {
    public String findLoggedInUsername();
    public void autologin(String username, String password);
}
