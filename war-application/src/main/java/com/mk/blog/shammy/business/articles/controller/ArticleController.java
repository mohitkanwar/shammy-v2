package com.mk.blog.shammy.business.articles.controller;

import com.mk.blog.shammy.business.articles.dto.ArticleDTO;
import com.mk.blog.shammy.business.articles.errors.ArticleErrors;
import com.mk.blog.shammy.business.articles.service.IArticleService;
import com.mk.blog.shammy.framework.controller.DataResponse;
import com.mk.blog.shammy.framework.controller.ErrorResponse;
import com.mk.blog.shammy.framework.controller.PaginatedListResponse;
import com.mk.blog.shammy.framework.controller.StatusResponse;
import com.mk.blog.shammy.framework.errors.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final IArticleService service;

    @Autowired
    public ArticleController(IArticleService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public DataResponse<ArticleDTO> getArticleById(@PathVariable long id) {
        DataResponse<ArticleDTO> response = new DataResponse<>();

        try {
            Optional<ArticleDTO> articleById = service.getArticleById(id);
            if (articleById.isPresent()) {
                ArticleDTO article = null;
                article = articleById.get();
                response.setData(article);
                response.setStatus(StatusResponse.SUCCESS);
            } else {
                ErrorResponse error = new ErrorResponse();
                error.setErrorCode(ArticleErrors.ARTICLE_NOT_FOUND_WITH_ID.toString());
                error.setAdditionalInfo(ArticleErrors.ARTICLE_NOT_FOUND_WITH_ID.getDescription());
                response.setError(error);
                response.setStatus(StatusResponse.FAILURE);
            }
        } catch (RuntimeException e) {
            ErrorResponse error = new ErrorResponse();
            error.setErrorCode(Errors.WTF.toString());
            error.setAdditionalInfo(Errors.WTF.getDescription());
            response.setError(error);
            response.setStatus(StatusResponse.FAILURE);
        }
        return response;
    }

    @GetMapping("/list")
    public PaginatedListResponse<ArticleDTO> getArticles() {
        PaginatedListResponse<ArticleDTO> response = new PaginatedListResponse<>();
        try {
            List<ArticleDTO> articles = service.getArticles();
            response.setStatus(StatusResponse.SUCCESS);
            response.setDataList(articles);
        } catch (RuntimeException e) {
            ErrorResponse error = new ErrorResponse();
            error.setErrorCode(Errors.WTF.toString());
            error.setAdditionalInfo(Errors.WTF.getDescription());
            response.setError(error);
            response.setStatus(StatusResponse.FAILURE);
            response.setDataList(new ArrayList<>());
        }
        return response;
    }

    @PostMapping
    public StatusResponse createArticle(@RequestBody ArticleDTO article) {
        try {
            service.save(article);
            return StatusResponse.SUCCESS;
        } catch (RuntimeException e) {
            return StatusResponse.FAILURE;
        }
    }

    @DeleteMapping("/{id}")
    public StatusResponse deleteArticle(@PathVariable long id) {
        try {
            service.delete(id);
            return StatusResponse.SUCCESS;
        } catch (RuntimeException e) {
            return StatusResponse.FAILURE;
        }
    }

    @PutMapping("/{id}")
    public StatusResponse updateArticle(@RequestBody ArticleDTO article) {
        try {
            service.save(article);
            return StatusResponse.SUCCESS;
        } catch (RuntimeException e) {
            return StatusResponse.FAILURE;
        }
    }
}


