package com.mk.blog.shammy.framework;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@SpringBootApplication
public class ShammyApplicationFramework {
    @Value("${shammy.security.realmname}")
    private  String realmName;
    public static void main(String[] args) {
        SpringApplication.run(ShammyApplicationFramework.class, args);
    }
    @Bean
    public AuthenticationEntryPoint getAuthEntryPoint(){
        BasicAuthenticationEntryPoint basicAuthenticationEntryPoint = new BasicAuthenticationEntryPoint();
        basicAuthenticationEntryPoint.setRealmName(realmName);
        return basicAuthenticationEntryPoint;
    }
}
