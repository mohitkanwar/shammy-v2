package com.mk.blog.shammy.business.user.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "MASTER_USER_DETAILS")
public class DefaultUserDetails implements UserDetails {
    @OneToMany(fetch = FetchType.EAGER)
    private List<DefaultAuthority> authorities;
    private String password;
    @Id
    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
}
