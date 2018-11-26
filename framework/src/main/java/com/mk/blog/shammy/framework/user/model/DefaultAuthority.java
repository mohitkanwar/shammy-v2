package com.mk.blog.shammy.framework.user.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Entity

@Table(name = "AUTHORITIES")
public class DefaultAuthority implements GrantedAuthority {
    @Id
    private long id;
    private String authority;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAuthority authority1 = (DefaultAuthority) o;
        return getId() == authority1.getId() &&
                Objects.equals(getAuthority(), authority1.getAuthority()) &&
                Objects.equals(getDescription(), authority1.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthority(), getDescription());
    }

}
