package com.mk.blog.shammy.business.user.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Data
@Table(name = "AUTHORITIES")
public class DefaultAuthority implements GrantedAuthority {
    @Id
    private long id;
    private String authority;
    private String description;


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
