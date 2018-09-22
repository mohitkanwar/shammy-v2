package com.mk.blog.shammy.business.user.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultUserDetailsTest {

    @Test
    public void equals() {
        DefaultUserDetails userDetails = new DefaultUserDetails();
        userDetails.setAuthorities(null);
        userDetails.setId(1);
        userDetails.setAccountNonExpired(true);
        userDetails.setAccountNonLocked(true);
        userDetails.setCredentialsNonExpired(true);
        userDetails.setEnabled(true);
        userDetails.setPassword("pwd");
        userDetails.setUsername("uname");

        DefaultUserDetails userDetails2 = new DefaultUserDetails();
        userDetails2.setAuthorities(null);
        userDetails2.setId(1);
        userDetails2.setAccountNonExpired(true);
        userDetails2.setAccountNonLocked(true);
        userDetails2.setCredentialsNonExpired(true);
        userDetails2.setEnabled(true);
        userDetails2.setPassword("pwd");
        userDetails2.setUsername("uname");

        assertEquals(userDetails, userDetails2);
        assertEquals(userDetails.hashCode(), userDetails2.hashCode());
    }
}