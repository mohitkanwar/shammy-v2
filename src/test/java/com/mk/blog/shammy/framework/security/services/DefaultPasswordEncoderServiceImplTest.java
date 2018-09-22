package com.mk.blog.shammy.framework.security.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultPasswordEncoderServiceImplTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void encode() {
       String encodedPwd =  passwordEncoder.encode("test");
       assertTrue(passwordEncoder.matches("test",encodedPwd));
    }

}