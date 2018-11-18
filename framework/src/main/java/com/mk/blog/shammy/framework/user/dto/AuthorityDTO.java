package com.mk.blog.shammy.framework.user.dto;

import lombok.Data;

@Data
public class AuthorityDTO {
    private long id;
    private String authority;
    private String description;
}
