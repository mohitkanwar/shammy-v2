package com.mk.blog.shammy.business.articles.adapter;

import com.mk.blog.shammy.business.articles.dto.ArticleDTO;
import com.mk.blog.shammy.business.articles.model.ArticleEntity;
import com.mk.blog.shammy.business.articles.model.SeoKeywordEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleAdapterTest {

    @Autowired
    private ArticleAdapter articleAdapter;

    @Test
    public void getEntityTest() {
        ArticleDTO dto = getArticleDTO();
        ArticleEntity entity = articleAdapter.getEntity(dto);
        Assert.assertEquals(getArticleEntity(), entity);
    }

    @Test
    public void getDtoTest() {
        ArticleEntity entity = getArticleEntity();
        ArticleDTO dto = articleAdapter.getDto(entity);
        Assert.assertEquals(getArticleDTO(), dto);
    }

    private ArticleDTO getArticleDTO() {
        ArticleDTO dto = new ArticleDTO();
        dto.setId(9L);
        dto.setTitle("Title");
        dto.setBody("Body");
        dto.setSummary("summary");
        dto.setCreateDate(LocalDate.now());
        dto.setCategory("category");
        List<String> keywords = new ArrayList<String>();
        keywords.add("key1");
        keywords.add("key2");
        dto.setSeoKeywords(keywords);
       // dto.setAuthor(new AuthorDTO());
        dto.setLastModifiedDate(LocalDate.now());
        return dto;
    }

    private ArticleEntity getArticleEntity() {
        ArticleEntity entity = new ArticleEntity();
        entity.setId(9L);
        entity.setTitle("Title");
        entity.setBody("Body");
        entity.setSummary("summary");
        entity.setCreateDate(LocalDate.now());
        entity.setCategory("category");
        List<SeoKeywordEntity> keywords = new ArrayList<SeoKeywordEntity>();
        keywords.add(new SeoKeywordEntity("key1"));
        keywords.add(new SeoKeywordEntity("key2"));
        entity.setSeoKeywords(keywords);       // entity.setAuthor(new AuthorEntity());
        entity.setLastModifiedDate(LocalDate.now());
        return entity;
    }

}