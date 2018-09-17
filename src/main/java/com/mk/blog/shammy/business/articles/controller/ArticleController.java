package com.mk.blog.shammy.articles.controller;

import com.mk.blog.shammy.articles.model.Article;
import com.mk.blog.shammy.articles.service.ArticleService;
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
    private ArticleService service;

    @GetMapping("/article/{id}")
    public Article getArticleById(@PathVariable long id){
        Article article = null;
        try{
            Optional<Article> articleById = service.getArticleById(id);
            if(articleById.isPresent()){
                article = articleById.get();
            }
            else {
                article = new Article();
            }
        }
        catch (RuntimeException e){
            article = new Article();
        }
        return article;
    }

    @GetMapping("/article/list")
    public ListResponse<Article> getArticles(){
        ListResponse<Article> response = new ListResponse<>();
        try{
            List<Article> articles = service.getArticles();

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
    public StatusResponse createArticle(@RequestBody Article article){
        try{
            service.save(article);
            return StatusResponse.SUCCESS;
        }catch (RuntimeException e){
            return StatusResponse.FAILURE;
        }
    }
}


