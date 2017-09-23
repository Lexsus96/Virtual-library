package com.mkyong.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Alex on 09.08.2016.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

    @Autowired
    private jdbcControl jdbcControl;

    @Transactional
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        Boolean b = jdbcControl.signIn(login, password);
        if(b) {
            User user = jdbcControl.getUser(login);
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            if(user.getAdmin()) {
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            } else {
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            }
            return new UsernamePasswordAuthenticationToken(login, password, grantedAuthorities);
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authetication) { return authetication.equals(UsernamePasswordAuthenticationToken.class);}
}
