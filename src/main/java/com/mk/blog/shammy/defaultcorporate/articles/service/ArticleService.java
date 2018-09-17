package com.mk.blog.shammy.articles.service;

import com.mk.blog.shammy.articles.model.Article;
import com.mk.blog.shammy.articles.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository repository;
    public void save(Article article) {
        repository.save(article);
    }
    public List<Article> getArticles(){
        List<Article> articlesList = new ArrayList<>();
        repository.findAll().forEach(articlesList::add);
        return articlesList;
    }

    public Optional<Article> getArticleById(long id) {
        return repository.findById(id);
    }
}
