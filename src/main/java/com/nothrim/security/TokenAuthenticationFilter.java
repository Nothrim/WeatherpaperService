package com.nothrim.security;

import com.nothrim.database.repositories.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Notrim on 08.05.2017.
 */
@Component
public class TokenAuthenticationFilter extends GenericFilterBean {
    private UserRepository userRepository;
    private UserDetailsService userDetailsService;

    public TokenAuthenticationFilter(UserRepository userRepository, UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;

        //extract token from header
        final String accessToken = httpRequest.getHeader("token");
        if (null != accessToken) {
            com.nothrim.database.models.security.User user = userRepository.findByToken(accessToken);
            if (user != null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
                //get and check whether token is valid ( from DB or file wherever you are storing the token)

                //Populate SecurityContextHolder by fetching relevant information using token
                final UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, user.getPassword(), userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }
}
