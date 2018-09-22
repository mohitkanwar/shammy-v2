package com.mk.blog.shammy.framework.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebSecurityConfigTest {
    @Autowired
    private WebSecurityConfig config;
    @Autowired
    private AuthenticationManagerBuilder builder;
    @Autowired
    private UserDetailsService userDetailsService;

    @Test
    public void configure() throws Exception {
        config.configure(builder);
    }
}