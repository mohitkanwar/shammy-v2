package com.mk.blog.shammy.business.articles.controller;

import com.mk.blog.shammy.business.articles.dto.ArticleDTO;
import com.mk.blog.shammy.business.articles.service.IArticleService;
import com.mk.blog.shammy.framework.controller.ListResponse;
import com.mk.blog.shammy.framework.controller.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ArticleController {

    @Autowired
    private IArticleService service;

    @GetMapping("/article/{id}")
    public ArticleDTO getArticleById(@PathVariable long id){
        ArticleDTO article = null;
        try{
            Optional<ArticleDTO> articleById = service.getArticleById(id);
            if(articleById.isPresent()){
                article = articleById.get();
            }
            else {
                article = new ArticleDTO();
            }
        }
        catch (RuntimeException e){
            article = new ArticleDTO();
        }
        return article;
    }

    @GetMapping("/article/list")
    public ListResponse<ArticleDTO> getArticles(){
        ListResponse<ArticleDTO> response = new ListResponse<>();
        try{
            List<ArticleDTO> articles = service.getArticles();
            response.setStatus(StatusResponse.SUCCESS);
            response.setDataList(articles);
        }
        catch (RuntimeException e){
            response.setStatus(StatusResponse.FAILURE);
            response.setDataList(new ArrayList<>());
        }
        return response;
    }
    @PostMapping("/article")
    public StatusResponse createArticle(@RequestBody ArticleDTO article){
        try{
            service.save(article);
            return StatusResponse.SUCCESS;
        }catch (RuntimeException e){
            return StatusResponse.FAILURE;
        }
    }
    @DeleteMapping("/article/{id}")
    public StatusResponse deleteArticle(@PathVariable long id){
        try{
            service.delete(id);
            return StatusResponse.SUCCESS;
        }catch (RuntimeException e){
            return StatusResponse.FAILURE;
        }
    }

    @PutMapping("/article/{id}")
    public StatusResponse updateArticle(@RequestBody ArticleDTO article){
        try{
            service.save(article);
            return StatusResponse.SUCCESS;
        }catch (RuntimeException e){
            return StatusResponse.FAILURE;
        }
    }
}


