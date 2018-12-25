package com.mk.blog.shammy.business.articles.controller;

import com.mk.blog.shammy.business.articles.dto.ArticleDTO;
import com.mk.blog.shammy.business.articles.service.IArticleService;
import com.mk.blog.shammy.framework.controller.DataResponse;
import com.mk.blog.shammy.framework.controller.PaginatedListResponse;
import com.mk.blog.shammy.framework.controller.StatusResponse;
import com.mk.blog.shammy.framework.errors.Errors;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleControllerTest {
    @Autowired
    private ArticleController controller;
    @MockBean
    private IArticleService service;

    @Test
    public void getArticleById() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setId(1L);
        mockArticle.setTitle("Mock Title");
        Optional<ArticleDTO> optionalArticleDTO = Optional.of(mockArticle);
        when(service.getArticleById(1)).thenReturn(optionalArticleDTO);
        DataResponse<ArticleDTO> articleResponse = controller.getArticleById(1);
        assertEquals(StatusResponse.SUCCESS,articleResponse.getStatus());
        assertEquals(mockArticle, articleResponse.getData());
    }

    @Test
    public void getArticleByIdExceptionCase() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setId(1L);
        mockArticle.setTitle("Mock Title");
        Optional<ArticleDTO> optionalArticleDTO = Optional.of(mockArticle);
        when(service.getArticleById(1)).thenThrow(new NullPointerException());
        DataResponse<ArticleDTO> articleResponse = controller.getArticleById(1);
        assertEquals(StatusResponse.FAILURE, articleResponse.getStatus());
    }

    @Test
    public void getArticles() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setId(1L);
        mockArticle.setTitle("Mock Title");
        List<ArticleDTO> articleDTOList = new ArrayList<>();
        articleDTOList.add(mockArticle);
        PaginatedListResponse<ArticleDTO> mockResponse = new PaginatedListResponse<>();
        mockResponse.setDataList(articleDTOList);
        when(service.getArticles(1,1,"id")).thenReturn(mockResponse);
        PaginatedListResponse<ArticleDTO> response = controller.getArticles(1,1,"id");
        assertEquals(StatusResponse.SUCCESS, response.getStatus());
        assertEquals(articleDTOList, response.getDataList());
    }

    @Test
    public void getArticlesExceptionCase() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setId(1L);
        mockArticle.setTitle("Mock Title");
        List<ArticleDTO> articleDTOList = new ArrayList<>();
        articleDTOList.add(mockArticle);
        when(service.getArticles(1,1,"ed")).thenThrow(new NullPointerException());
        PaginatedListResponse<ArticleDTO> response = controller.getArticles(1,1,"ed");
        assertEquals(StatusResponse.FAILURE, response.getStatus());
        assertEquals(new ArrayList<>(), response.getDataList());
        assertEquals(Errors.WTF.toString(), response.getError().getErrorCode());
        assertEquals(Errors.WTF.getDescription(), response.getError().getAdditionalInfo());
    }

    @Test
    public void createArticle() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setTitle("Mock Title");
        ArticleDTO mockArticleWithId = new ArticleDTO();
        mockArticleWithId.setId(1L);
        mockArticleWithId.setTitle("Mock Title");
        when(service.save(mockArticle)).thenReturn(mockArticleWithId);
        DataResponse<ArticleDTO> response = controller.createArticle(mockArticle);
        assertEquals(StatusResponse.SUCCESS, response.getStatus());
        assertEquals(1L,(long)response.getData().getId());
    }

    @Test
    public void createArticleExceptionCase() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setId(1L);
        mockArticle.setTitle("Mock Title");
        Mockito.doThrow(new NullPointerException()).when(service).save(mockArticle);
        DataResponse response = controller.createArticle(mockArticle);
        assertEquals(StatusResponse.FAILURE, response.getStatus());
    }

    @Test
    public void deleteArticle() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setId(1L);
        mockArticle.setTitle("Mock Title");
        Mockito.doNothing().when(service).delete(1l);
        StatusResponse response = controller.deleteArticle(1l);
        assertEquals(StatusResponse.SUCCESS, response);
    }

    @Test
    public void deleteArticleException() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setId(1L);
        mockArticle.setTitle("Mock Title");
        Mockito.doThrow(new NullPointerException()).when(service).delete(1l);
        StatusResponse response = controller.deleteArticle(1l);
        assertEquals(StatusResponse.FAILURE, response);
    }

    @Test
    public void updateArticle() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setId(1L);
        mockArticle.setTitle("Mock Title");
        ArticleDTO mockArticleWithId = new ArticleDTO();
        mockArticleWithId.setId(1L);
        mockArticleWithId.setTitle("Mock Title");
        when(service.save(mockArticle)).thenReturn(mockArticleWithId);
        StatusResponse response = controller.updateArticle(mockArticle);
        assertEquals(StatusResponse.SUCCESS, response);
    }

    @Test
    public void updateArticleException() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setId(1L);
        mockArticle.setTitle("Mock Title");
        Mockito.doThrow(new NullPointerException()).when(service).save(mockArticle);
        StatusResponse response = controller.updateArticle(mockArticle);
        assertEquals(StatusResponse.FAILURE, response);
    }
}