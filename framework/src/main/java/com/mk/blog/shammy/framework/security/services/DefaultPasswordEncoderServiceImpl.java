package com.mk.blog.shammy.framework.security.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultPasswordEncoderServiceImpl implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {

        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(encode(charSequence));
    }
}