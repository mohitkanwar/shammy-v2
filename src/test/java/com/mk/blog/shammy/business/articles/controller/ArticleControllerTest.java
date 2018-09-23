package com.mk.blog.shammy.business.articles.controller;

import com.mk.blog.shammy.business.articles.dto.ArticleDTO;
import com.mk.blog.shammy.business.articles.service.IArticleService;
import com.mk.blog.shammy.framework.controller.DataResponse;
import com.mk.blog.shammy.framework.controller.ListResponse;
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
        mockArticle.setId(1l);
        mockArticle.setTitle("Mock Title");
        Optional<ArticleDTO> optionalArticleDTO = Optional.of(mockArticle);
        Mockito.when(service.getArticleById(1)).thenReturn(optionalArticleDTO);
        DataResponse<ArticleDTO> articleResponse = controller.getArticleById(1);
        Assert.assertEquals(StatusResponse.SUCCESS,articleResponse.getStatus());
        Assert.assertEquals(mockArticle, articleResponse.getData());
    }

    @Test
    public void getArticleByIdExceptionCase() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setId(1l);
        mockArticle.setTitle("Mock Title");
        Optional<ArticleDTO> optionalArticleDTO = Optional.of(mockArticle);
        Mockito.when(service.getArticleById(1)).thenThrow(new NullPointerException());
        DataResponse<ArticleDTO> articleResponse = controller.getArticleById(1);
        Assert.assertEquals(StatusResponse.FAILURE, articleResponse.getStatus());
    }

    @Test
    public void getArticles() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setId(1l);
        mockArticle.setTitle("Mock Title");
        List<ArticleDTO> articleDTOList = new ArrayList<>();
        articleDTOList.add(mockArticle);
        Mockito.when(service.getArticles()).thenReturn(articleDTOList);
        ListResponse<ArticleDTO> response = controller.getArticles();
        Assert.assertEquals(StatusResponse.SUCCESS, response.getStatus());
        Assert.assertEquals(articleDTOList, response.getDataList());
        Assert.assertEquals(1, response.getSize());
    }

    @Test
    public void getArticlesExceptionCase() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setId(1l);
        mockArticle.setTitle("Mock Title");
        List<ArticleDTO> articleDTOList = new ArrayList<>();
        articleDTOList.add(mockArticle);
        Mockito.when(service.getArticles()).thenThrow(new NullPointerException());
        ListResponse<ArticleDTO> response = controller.getArticles();
        Assert.assertEquals(StatusResponse.FAILURE, response.getStatus());
        Assert.assertEquals(new ArrayList<>(), response.getDataList());
        Assert.assertEquals(Errors.WTF.toString(), response.getError().getErrorCode());
        Assert.assertEquals(Errors.WTF.getDescription(), response.getError().getAdditionalInfo());
    }

    @Test
    public void createArticle() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setId(1l);
        mockArticle.setTitle("Mock Title");
        Mockito.doNothing().when(service).save(mockArticle);
        StatusResponse response = controller.createArticle(mockArticle);
        Assert.assertEquals(StatusResponse.SUCCESS, response);
    }

    @Test
    public void createArticleExceptionCase() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setId(1l);
        mockArticle.setTitle("Mock Title");
        Mockito.doThrow(new NullPointerException()).when(service).save(mockArticle);
        StatusResponse response = controller.createArticle(mockArticle);
        Assert.assertEquals(StatusResponse.FAILURE, response);
    }

    @Test
    public void deleteArticle() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setId(1l);
        mockArticle.setTitle("Mock Title");
        Mockito.doNothing().when(service).delete(1l);
        StatusResponse response = controller.deleteArticle(1l);
        Assert.assertEquals(StatusResponse.SUCCESS, response);
    }

    @Test
    public void deleteArticleException() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setId(1l);
        mockArticle.setTitle("Mock Title");
        Mockito.doThrow(new NullPointerException()).when(service).delete(1l);
        StatusResponse response = controller.deleteArticle(1l);
        Assert.assertEquals(StatusResponse.FAILURE, response);
    }

    @Test
    public void updateArticle() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setId(1l);
        mockArticle.setTitle("Mock Title");
        Mockito.doNothing().when(service).save(mockArticle);
        StatusResponse response = controller.updateArticle(mockArticle);
        Assert.assertEquals(StatusResponse.SUCCESS, response);
    }

    @Test
    public void updateArticleException() {
        ArticleDTO mockArticle = new ArticleDTO();
        mockArticle.setId(1l);
        mockArticle.setTitle("Mock Title");
        Mockito.doThrow(new NullPointerException()).when(service).save(mockArticle);
        StatusResponse response = controller.updateArticle(mockArticle);
        Assert.assertEquals(StatusResponse.FAILURE, response);
    }
}