package com.mk.blog.shammy.defaultcorporate.articles.service;

import com.mk.blog.shammy.business.articles.adapter.ArticleAdapter;
import com.mk.blog.shammy.business.articles.dto.ArticleDTO;
import com.mk.blog.shammy.business.articles.model.ArticleEntity;
import com.mk.blog.shammy.business.articles.model.SeoKeywordEntity;
import com.mk.blog.shammy.business.articles.repository.IArticleRepository;
import com.mk.blog.shammy.framework.controller.PaginatedListResponse;
import com.mk.blog.shammy.framework.user.model.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.*;

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
        dto.setCreateDate(LocalDate.now());
        dto.setCategory("category");
        List<String> keywords = new ArrayList<String>();
        keywords.add("key1");
        keywords.add("key2");
        dto.setSeoKeywords(keywords);
        dto.setLastModifiedDate(LocalDate.now());
        return dto;
    }

    private ArticleEntity getArticleEntity() {
        ArticleEntity entity = new ArticleEntity();
        entity.setId(9l);
        entity.setTitle("Title");
        entity.setBody("Body");
        entity.setSummary("summary");
        entity.setCreateDate(LocalDate.now());
        entity.setCategory("category");
        Set<SeoKeywordEntity> keywords = new HashSet<SeoKeywordEntity>();
        keywords.add(new SeoKeywordEntity("key1"));
        keywords.add(new SeoKeywordEntity("key2"));
        entity.setSeoKeywords(keywords);
        UserEntity authorEntity = new UserEntity();
        entity.setAuthor(authorEntity);
        entity.setLastModifiedDate(LocalDate.now());
        return entity;
    }

    @Test
    public void getArticles() {
        List<ArticleEntity> articleEntitiesList = new ArrayList<>();
        ArticleEntity entity = getArticleEntity();
        articleEntitiesList.add(entity);
        Page<ArticleEntity> articlePage = new PageImpl<>(articleEntitiesList) ;


        when(repository.findAll(PageRequest.of(1,1, Sort.by("id")))).thenReturn(articlePage);
        when(articleAdapter.getDto(getArticleEntity())).thenReturn(getArticleDTO());
        PaginatedListResponse<ArticleDTO> output = service.getArticles(1,1,"id");
        Assert.assertEquals(1, output.getDataList().size());
        Assert.assertEquals(getArticleDTO(), output.getDataList().get(0));
    }

    @Test
    public void getArticleById() {
        when(repository.findById(1l)).thenReturn(Optional.of(getArticleEntity()));
        when(articleAdapter.getDto(getArticleEntity())).thenReturn(getArticleDTO());
        Optional<ArticleDTO> op = service.getArticleById(1l);
        Assert.assertEquals(Optional.of(getArticleDTO()), op);
    }

    @Test
    public void delete() {
        when(repository.existsById(1l)).thenReturn(true);
        doNothing().when(repository).deleteById(1l);
        service.delete(1l);
    }
}