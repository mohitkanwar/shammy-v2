package com.mk.blog.shammy.business.articles.service;


import com.mk.blog.shammy.business.articles.dto.ArticleDTO;
import com.mk.blog.shammy.framework.controller.PaginatedListResponse;

import java.util.List;
import java.util.Optional;

public interface IArticleService {
    ArticleDTO save(ArticleDTO article);

    PaginatedListResponse<ArticleDTO> getArticles(int pageSize, int pageNumber, String sortBy);

    PaginatedListResponse<ArticleDTO> getNonDeletedArticles(int pageSize, int pageNumber, String sortBy);

    Optional<ArticleDTO> getArticleById(long id);

    void softDelete(long id);
    void delete(long id);
}
