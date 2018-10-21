package com.mk.blog.shammy.framework.security.services;

import com.mk.blog.shammy.business.user.model.DefaultAuthority;
import com.mk.blog.shammy.business.user.model.UserEntity;
import com.mk.blog.shammy.business.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntityServiceImplTest {

    @Autowired
    UserDetailsService userDetailsService;
    @MockBean
    private UserRepository userRepository;

    @Test
    public void loadUserByUsername() {
        UserEntity user = new UserEntity();
        user.setUsername("username");
        user.setPassword("password");
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);
        user.setAccountNonExpired(true);
        user.setId(1);

        List<DefaultAuthority> authorities = new ArrayList<>();
        DefaultAuthority authority = new DefaultAuthority();
        authority.setAuthority("ADMIIN");
        authority.setDescription("This is an admin user");
        authority.setId(1);
        authorities.add(authority);
        user.setAuthorities(authorities);
        when(userRepository.findDefaultUserDetailsByUsername("username"))
                .thenReturn(user);
        UserDetails userFromService = userDetailsService.loadUserByUsername("username");
        assertEquals(user, userFromService);
    }
}