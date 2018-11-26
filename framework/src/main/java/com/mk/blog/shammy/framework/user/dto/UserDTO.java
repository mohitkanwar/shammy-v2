package com.mk.blog.shammy.framework.user.dto;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDTO {
    private Long id;
    private List<AuthorityDTO> authorities;
    private String password;
    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private String firstName;
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AuthorityDTO> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<AuthorityDTO> authorities) {
        this.authorities = authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserDTO(){
        setAuthorities(new ArrayList<>());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;
        UserDTO userDTO = (UserDTO) o;
        if(getId()==null && userDTO.getId() ==null){
            return  isAccountNonExpired() == userDTO.isAccountNonExpired() &&
                    isAccountNonLocked() == userDTO.isAccountNonLocked() &&
                    isCredentialsNonExpired() == userDTO.isCredentialsNonExpired() &&
                    isEnabled() == userDTO.isEnabled() &&
                    Objects.equals(getAuthorities(), userDTO.getAuthorities()) &&
                    Objects.equals(getPassword(), userDTO.getPassword()) &&
                    Objects.equals(getUsername(), userDTO.getUsername()) &&
                    Objects.equals(getFirstName(), userDTO.getFirstName()) &&
                    Objects.equals(getLastName(), userDTO.getLastName());
        }
        return getId() == userDTO.getId() ;

    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthorities(), getPassword(), getUsername(), isAccountNonExpired(), isAccountNonLocked(), isCredentialsNonExpired(), isEnabled(), getFirstName(), getLastName());
    }
}
