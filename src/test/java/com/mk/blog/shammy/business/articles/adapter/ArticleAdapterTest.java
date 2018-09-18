package com.mk.blog.shammy.business.articles.adapter;

import com.mk.blog.shammy.business.articles.dto.ArticleDTO;
import com.mk.blog.shammy.business.articles.model.ArticleEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleAdapterTest {

    @Autowired
    private ArticleAdapter articleAdapter;

    @Test
    public void getEntityTest() {
        ArticleDTO dto = getArticleDTO();
        ArticleEntity entity = articleAdapter.getEntity(dto);
        Assert.assertEquals(getArticleEntity(),entity);
    }
    @Test
    public void getDtoTest() {
        ArticleEntity entity = getArticleEntity();
        ArticleDTO dto = articleAdapter.getDto(entity);
        Assert.assertEquals(getArticleDTO(),dto);
    }
    private ArticleDTO getArticleDTO() {
        ArticleDTO dto = new ArticleDTO();
        dto.setId(9l);
        dto.setTitle("Title");
        dto.setBody("Body");
        dto.setSummary("summary");
        dto.setCreateDate("new create date");
        dto.setCategory("category");
        dto.setTags("tag1,tag2");
        dto.setAuthorName("author name");
        dto.setLastModifiedDate("last modified date");
        return dto;
    }
    private ArticleEntity getArticleEntity() {
        ArticleEntity entity = new ArticleEntity();
        entity.setId(9l);
        entity.setTitle("Title");
        entity.setBody("Body");
        entity.setSummary("summary");
        entity.setCreateDate("new create date");
        entity.setCategory("category");
        entity.setTags("tag1,tag2");
        entity.setAuthorName("author name");
        entity.setLastModifiedDate("last modified date");
        return entity;
    }

}