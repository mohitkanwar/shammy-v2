package com.mk.blog.shammy.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAuthority('USER')")
public class SecurityController {
    @GetMapping("/secure")
    public String getSecureWord(){
        return "Hello Secure World";
    }
}
