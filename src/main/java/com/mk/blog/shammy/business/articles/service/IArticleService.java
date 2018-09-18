package com.mk.blog.shammy.business.articles.service;


import com.mk.blog.shammy.business.articles.dto.ArticleDTO;

import java.util.List;
import java.util.Optional;

public interface IArticleService {
    void save(ArticleDTO article);

    List<ArticleDTO> getArticles();

    Optional<ArticleDTO> getArticleById(long id);

    void delete(long id);
}
