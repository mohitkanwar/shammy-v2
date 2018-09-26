package com.mk.blog.shammy.business.authors.dto;

import com.mk.blog.shammy.business.articles.dto.ArticleDTO;
import com.mk.blog.shammy.business.user.dto.UserDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AuthorDTO {
    private List<ArticleDTO> articles;
    private UserDTO userDTO;
    private long id;
    public AuthorDTO(){
        this.setArticles(new ArrayList<>());
        this.setUserDTO(new UserDTO());
    }
}
