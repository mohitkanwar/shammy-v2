package com.mk.blog.shammy.business.authors.adapter;


import com.mk.blog.shammy.business.articles.adapter.ArticleAdapter;
import com.mk.blog.shammy.business.articles.dto.ArticleDTO;
import com.mk.blog.shammy.business.articles.model.ArticleEntity;
import com.mk.blog.shammy.business.authors.dto.AuthorDTO;
import com.mk.blog.shammy.business.authors.model.AuthorEntity;
import com.mk.blog.shammy.business.user.adapter.UserAdapter;
import com.mk.blog.shammy.business.user.model.DefaultAuthority;
import com.mk.blog.shammy.framework.adapters.DtoToEntityAdapter;
import com.mk.blog.shammy.framework.adapters.EntityToDtoAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorAdapter implements EntityToDtoAdapter<AuthorEntity, AuthorDTO>, DtoToEntityAdapter<AuthorDTO, AuthorEntity> {
    @Autowired
    private ArticleAdapter articleAdapter;
    @Autowired
    private UserAdapter userAdapter;

    @Override
    public AuthorEntity getEntity(AuthorDTO authorDTO) {
       AuthorEntity entity = new AuthorEntity();
       entity.setUserDetails(userAdapter.getEntity(authorDTO.getUserDTO()));
       List<ArticleEntity> articles = authorDTO.getArticles().stream()
                .map(articleAdapter::getEntity).collect(Collectors.toList());
       entity.setArticles(articles);
       return entity;
    }

    @Override
    public AuthorDTO getDto(AuthorEntity d) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(d.getId());
        authorDTO.setUserDTO(userAdapter.getDto(d.getUserDetails()));
        authorDTO.setArticles(
                d.getArticles().stream().map(articleAdapter::getDto).collect(Collectors.toList())
        );
        return authorDTO;
    }
}
