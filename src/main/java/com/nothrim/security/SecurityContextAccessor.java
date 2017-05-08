package com.nothrim.security;

/**
 * Created by Notrim on 24.04.2017.
 */
public interface SecurityContextAccessor {
    boolean isCurrentAuthenticationAnonymous();
}
