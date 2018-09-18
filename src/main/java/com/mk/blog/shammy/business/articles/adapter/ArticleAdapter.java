package com.mk.blog.shammy.business.articles.adapter;


import com.mk.blog.shammy.business.articles.dto.ArticleDTO;
import com.mk.blog.shammy.business.articles.model.ArticleEntity;
import com.mk.blog.shammy.framework.adapters.DtoToEntityAdapter;
import com.mk.blog.shammy.framework.adapters.EntityToDtoAdapter;
import org.springframework.stereotype.Component;

@Component
public class ArticleAdapter implements EntityToDtoAdapter<ArticleEntity, ArticleDTO>, DtoToEntityAdapter<ArticleDTO,ArticleEntity> {

    @Override
    public ArticleEntity getEntity(ArticleDTO d) {
        ArticleEntity entity = new ArticleEntity();
        entity.setId(d.getId());
        entity.setTitle(d.getTitle());
        entity.setBody(d.getBody());
        entity.setSummary(d.getSummary());
        entity.setAuthorName(d.getAuthorName());
        entity.setCreateDate(d.getCreateDate());
        entity.setLastModifiedDate(d.getLastModifiedDate());
        entity.setTags(d.getTags());
        entity.setCategory(d.getCategory());
        return entity;
    }

    @Override
    public ArticleDTO getDto(ArticleEntity entity) {
        ArticleDTO dto = new ArticleDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setBody(entity.getBody());
        dto.setSummary(entity.getSummary());
        dto.setAuthorName(entity.getAuthorName());
        dto.setCreateDate(entity.getCreateDate());
        dto.setLastModifiedDate(entity.getLastModifiedDate());
        dto.setTags(entity.getTags());
        dto.setCategory(entity.getCategory());
        return dto;
    }
}
