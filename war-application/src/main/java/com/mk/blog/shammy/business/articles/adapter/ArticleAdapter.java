package com.mk.blog.shammy.business.articles.adapter;


import com.mk.blog.shammy.business.articles.dto.ArticleDTO;
import com.mk.blog.shammy.business.articles.model.ArticleEntity;
import com.mk.blog.shammy.framework.user.adapter.UserAdapter;
import com.mk.blog.shammy.framework.adapters.DtoToEntityAdapter;
import com.mk.blog.shammy.framework.adapters.EntityToDtoAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ArticleAdapter implements EntityToDtoAdapter<ArticleEntity, ArticleDTO>, DtoToEntityAdapter<ArticleDTO, ArticleEntity> {

    private final UserAdapter authorAdapter;
    private final KeywordAdapter keywordAdapter;

    @Autowired
    public ArticleAdapter(UserAdapter authorAdapter, KeywordAdapter keywordAdapter) {
        this.authorAdapter = authorAdapter;
        this.keywordAdapter = keywordAdapter;
    }

    @Override
    public ArticleEntity getEntity(ArticleDTO d) {
        ArticleEntity entity = new ArticleEntity();
        entity.setId(d.getId());
        entity.setTitle(d.getTitle());
        entity.setBody(d.getBody());
        entity.setSummary(d.getSummary());
        entity.setCreateDate(d.getCreateDate());
        entity.setLastModifiedDate(d.getLastModifiedDate());
        entity.setSeoKeywords(d.getSeoKeywords().stream().map(keywordAdapter::getEntity).collect(Collectors.toSet()));
        entity.setCategory(d.getCategory());
        entity.setPublishingState(d.getPublishingState());
        return entity;
    }

    @Override
    public ArticleDTO getDto(ArticleEntity entity) {
        ArticleDTO dto = new ArticleDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setBody(entity.getBody());
        dto.setSummary(entity.getSummary());
        dto.setCreateDate(entity.getCreateDate());
        dto.setLastModifiedDate(entity.getLastModifiedDate());
        dto.setSeoKeywords(entity.getSeoKeywords().stream().map(keywordAdapter::getDto).collect(Collectors.toList()));
        dto.setCategory(entity.getCategory());
        dto.setPublishingState(entity.getPublishingState());
        return dto;
    }
}
