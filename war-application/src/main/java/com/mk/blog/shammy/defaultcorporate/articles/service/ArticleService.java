package com.mk.blog.shammy.defaultcorporate.articles.service;

import com.mk.blog.shammy.business.articles.adapter.ArticleAdapter;
import com.mk.blog.shammy.business.articles.adapter.KeywordAdapter;
import com.mk.blog.shammy.business.articles.dto.ArticleDTO;
import com.mk.blog.shammy.business.articles.model.ArticleEntity;
import com.mk.blog.shammy.business.articles.model.SeoKeywordEntity;
import com.mk.blog.shammy.business.articles.publishing.PublishingState;
import com.mk.blog.shammy.business.articles.repository.IArticleRepository;
import com.mk.blog.shammy.business.articles.repository.ISEOKeywordRepository;
import com.mk.blog.shammy.business.articles.service.IArticleService;
import com.mk.blog.shammy.business.articles.service.ISeoKeywordService;
import com.mk.blog.shammy.framework.controller.PaginatedListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleService implements IArticleService {
    private final IArticleRepository repository;
    private final ArticleAdapter adapter;
    private final ISEOKeywordRepository seoKeywordRepository;
    private final KeywordAdapter keywordAdapter;
    @Autowired
    public ArticleService(IArticleRepository repository, ArticleAdapter adapter,ISEOKeywordRepository seoKeywordRepository,KeywordAdapter keywordAdapter) {
        this.repository = repository;
        this.adapter = adapter;
        this.seoKeywordRepository=seoKeywordRepository;
        this.keywordAdapter = keywordAdapter;
    }

    @Override
    public ArticleDTO save(ArticleDTO article) {
        ArticleEntity entity = adapter.getEntity(article);
        Set<SeoKeywordEntity> keywords = new HashSet<>(article.getSeoKeywords().size());
        article.getSeoKeywords().forEach(keyword->{
            SeoKeywordEntity keywordEntity = keywordAdapter.getEntity(keyword);
            if (keywordEntity.getId() == null){
                seoKeywordRepository.save(keywordEntity);
                keywordEntity = seoKeywordRepository.findByKeyword(keyword).orElse(keywordEntity);
            }
            keywords.add(keywordEntity);
        });
        entity.setSeoKeywords(keywords);
        return adapter.getDto(repository.save(entity));
    }

    @Override
    public PaginatedListResponse<ArticleDTO> getArticles(int pageSize, int pageNumber, String sortBy) {
        PaginatedListResponse<ArticleDTO> response = new PaginatedListResponse<>();
        List<ArticleDTO> articlesList = new ArrayList<>();
        Page<ArticleEntity> articlePage = repository.findAll(PageRequest.of(pageNumber,pageSize, Sort.by(sortBy)));
        articlePage.forEach(entity -> articlesList.add(adapter.getDto(entity)));
        response.setDataList(articlesList);
        response.setPageNumber(articlePage.getNumber());
        response.setPageSize(articlePage.getSize());
        response.setTotalsize(articlePage.getTotalElements());
        return response;
    }
    @Override
    public PaginatedListResponse<ArticleDTO> getNonDeletedArticles(int pageSize, int pageNumber, String sortBy) {
        PaginatedListResponse<ArticleDTO> response = new PaginatedListResponse<>();
        List<ArticleDTO> articlesList = new ArrayList<>();
        Page<ArticleEntity> articlePage = repository.findArticleEntitiesByPublishingStateIsNot(PublishingState.DELETED.getId(),PageRequest.of(pageNumber,pageSize, Sort.by(sortBy)));
        articlePage.forEach(entity -> articlesList.add(adapter.getDto(entity)));
        response.setDataList(articlesList);
        response.setPageNumber(articlePage.getNumber());
        response.setPageSize(articlePage.getSize());
        response.setTotalsize(articlePage.getTotalElements());
        return response;
    }

    @Override
    public Optional<ArticleDTO> getArticleById(long id) {
        Optional<ArticleEntity> entity = repository.findById(id);
        ArticleDTO dto = null;
        if (entity.isPresent()) {
            dto = adapter.getDto(entity.get());
        }
        return dto == null ? Optional.empty() : Optional.of(dto);
    }

    @Override
    public void softDelete(long id) {
        repository.findById(id).ifPresent(articleEntity -> {
            articleEntity.setPublishingState(PublishingState.DELETED);
            repository.save(articleEntity);
        });
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }


}
