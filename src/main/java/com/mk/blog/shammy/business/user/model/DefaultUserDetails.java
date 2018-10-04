package com.mk.blog.shammy.business.user.model;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "USERS")
public class DefaultUserDetails implements UserDetails {

    @Id
    private long id;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "USER_AUTHORITIES",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id")}
    )
    private List<DefaultAuthority> authorities;
    private String password;
    @Column(unique = true)
    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private String firstName;
    private String lastName;

    public DefaultUserDetails(){
        this.setAuthorities(new ArrayList<>());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultUserDetails that = (DefaultUserDetails) o;
        return getId() == that.getId() &&
                isAccountNonExpired() == that.isAccountNonExpired() &&
                isAccountNonLocked() == that.isAccountNonLocked() &&
                isCredentialsNonExpired() == that.isCredentialsNonExpired() &&
                isEnabled() == that.isEnabled() &&
                Objects.equals(getAuthorities(), that.getAuthorities()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getUsername(), that.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthorities(), getPassword(), getUsername(), isAccountNonExpired(), isAccountNonLocked(), isCredentialsNonExpired(), isEnabled());
    }
}
