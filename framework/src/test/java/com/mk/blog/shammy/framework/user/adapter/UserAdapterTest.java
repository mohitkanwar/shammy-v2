package com.mk.blog.shammy.framework.user.adapter;


import com.mk.blog.shammy.framework.user.dto.AuthorityDTO;
import com.mk.blog.shammy.framework.user.dto.UserDTO;
import com.mk.blog.shammy.framework.user.model.DefaultAuthority;
import com.mk.blog.shammy.framework.user.model.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAdapterTest {

    @Autowired
    private UserAdapter userAdapter;

    @Test
    public void getEntity() {
        UserEntity fromAdapter = userAdapter.getEntity(getUserDto());
        assertEquals(getDefaultUserDetails(),fromAdapter);
    }

    @Test
    public void getDto() {
        UserDTO fromAdapter = userAdapter.getDto(getDefaultUserDetails());
        assertEquals(getUserDto(),fromAdapter);
    }


    private UserEntity getDefaultUserDetails(){
        UserEntity user = new UserEntity();
        List<DefaultAuthority> authorities = new ArrayList<>();
        DefaultAuthority authority = new DefaultAuthority();
        authority.setAuthority("authority");
        authority.setId(44);
        authority.setDescription("description");
        authorities.add(authority);
        user.setAuthorities(authorities);
        user.setUsername("username");
        user.setPassword("password");
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);
        user.setAccountNonExpired(true);
        user.setId(2l);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        return user;
    }
    private UserDTO getUserDto(){
        UserDTO userDTO = new UserDTO();
        List<AuthorityDTO> authList = new ArrayList<>();
        AuthorityDTO authDto = new AuthorityDTO();
        authDto.setAuthority("authority");
        authDto.setDescription("description");
        authDto.setId(44);
        authList.add(authDto);
        userDTO.setAuthorities(authList);
        userDTO.setId(2l);
        userDTO.setFirstName("firstName");
        userDTO.setUsername("username");
        userDTO.setPassword("password");
        userDTO.setEnabled(true);
        userDTO.setAccountNonExpired(true);
        userDTO.setAccountNonLocked(true);
        userDTO.setLastName("lastName");
        userDTO.setCredentialsNonExpired(true);
        return userDTO;
    }
}