package com.mk.blog.shammy.business.articles.controller;

import com.mk.blog.shammy.business.articles.dto.ArticleDTO;
import com.mk.blog.shammy.business.articles.errors.ArticleErrors;
import com.mk.blog.shammy.business.articles.publishing.PublishingState;
import com.mk.blog.shammy.business.articles.service.IArticleService;
import com.mk.blog.shammy.framework.controller.DataResponse;
import com.mk.blog.shammy.framework.controller.ErrorResponse;
import com.mk.blog.shammy.framework.controller.PaginatedListResponse;
import com.mk.blog.shammy.framework.controller.StatusResponse;
import com.mk.blog.shammy.framework.errors.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
            e.printStackTrace();
            ErrorResponse error = new ErrorResponse();
            error.setErrorCode(Errors.WTF.toString());
            error.setAdditionalInfo(Errors.WTF.getDescription());
            response.setError(error);
            response.setStatus(StatusResponse.FAILURE);
        }
        return response;
    }

    @GetMapping("/list")
    public PaginatedListResponse<ArticleDTO> getArticles(@RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize,
                                                         @RequestParam(name = "pageNumber",required = false,defaultValue = "0") int pageNumber,
                                                         @RequestParam(name = "sortBy",required = false,defaultValue = "id") String sortBy) {
        PaginatedListResponse<ArticleDTO> response ;
        try {
            response = service.getNonDeletedArticles(pageSize,pageNumber,sortBy);
            response.setStatus(StatusResponse.SUCCESS);
        } catch (RuntimeException e) {
            response = new PaginatedListResponse<>();
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
    public DataResponse<ArticleDTO> createArticle(@RequestBody ArticleDTO article) {
        DataResponse<ArticleDTO> response = new DataResponse<>();
        try {
            if(article.getPublishingState()==null){
                article.setPublishingState(PublishingState.DRAFT);
            }
            response.setData(service.save(article));
            response.setStatus(StatusResponse.SUCCESS);
        } catch (RuntimeException e) {
            e.printStackTrace();
            response.setStatus(StatusResponse.FAILURE);        }
        return response;
    }

    @DeleteMapping("/{id}")
    public  StatusResponse deleteArticle(@PathVariable long id) {
        try {
            service.softDelete(id);
            System.out.println(StatusResponse.SUCCESS);
            return StatusResponse.SUCCESS;
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println(StatusResponse.FAILURE);
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


