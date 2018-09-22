package com.mk.blog.shammy.framework.security.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DefaultDaoAuthenticationProviderService extends DaoAuthenticationProvider {

    @Autowired
    public DefaultDaoAuthenticationProviderService(@Autowired PasswordEncoder passwordEncoder, @Autowired UserDetailsService detailsService) {
        super();
        this.setUserDetailsService(detailsService);
    }
}