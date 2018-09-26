package com.mk.blog.shammy.business.user.dto;

import com.mk.blog.shammy.business.user.model.DefaultAuthority;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class UserDTO {
    private long id;
    private List<AuthorityDTO> authorities;
    private String password;
    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private String firstName;
    private String lastName;
    public UserDTO(){
        setAuthorities(new ArrayList<>());
    }
}
