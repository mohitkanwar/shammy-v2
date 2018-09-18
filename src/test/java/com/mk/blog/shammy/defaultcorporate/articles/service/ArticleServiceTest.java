package com.mk.blog.shammy.defaultcorporate.articles.service;

import com.mk.blog.shammy.business.articles.adapter.ArticleAdapter;
import com.mk.blog.shammy.business.articles.dto.ArticleDTO;
import com.mk.blog.shammy.business.articles.model.ArticleEntity;
import com.mk.blog.shammy.business.articles.repository.IArticleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {
    @Autowired
    private ArticleService service;
    @MockBean
    private IArticleRepository repository;
    @MockBean
    private ArticleAdapter articleAdapter;

    @Test
    public void save() {
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
    @Test
    public void getArticles() {
        List<ArticleEntity> articleEntitiesList = new ArrayList<>();
        ArticleEntity entity =  getArticleEntity();

        articleEntitiesList.add(entity);
        when(repository.findAll()).thenReturn(articleEntitiesList);
        when(articleAdapter.getDto(getArticleEntity())).thenReturn(getArticleDTO());
        List<ArticleDTO> output = service.getArticles();
        Assert.assertEquals(1,output.size());
        Assert.assertEquals(getArticleDTO(),output.get(0));
    }

    @Test
    public void getArticleById() {
        when(repository.findById(1l)).thenReturn(Optional.of(getArticleEntity()));
        when(articleAdapter.getDto(getArticleEntity())).thenReturn(getArticleDTO());
        Optional<ArticleDTO> op = service.getArticleById(1l);
        Assert.assertEquals(Optional.of(getArticleDTO()),op);
    }

    @Test
    public void delete() {
        when(repository.existsById(1l)).thenReturn(true);
        doNothing().when(repository).deleteById(1l);
        service.delete(1l);
    }
}