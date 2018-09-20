package com.mk.blog.shammy.business.user.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "MASTER_AUTHORITY_DETAILS")
public class DefaultAuthority implements GrantedAuthority {
    private String authority;
    private String description;

}
