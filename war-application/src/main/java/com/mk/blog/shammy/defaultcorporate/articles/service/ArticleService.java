package com.mk.blog.shammy.defaultcorporate.articles.service;

import com.mk.blog.shammy.business.articles.adapter.ArticleAdapter;
import com.mk.blog.shammy.business.articles.dto.ArticleDTO;
import com.mk.blog.shammy.business.articles.model.ArticleEntity;
import com.mk.blog.shammy.business.articles.repository.IArticleRepository;
import com.mk.blog.shammy.business.articles.service.IArticleService;
import com.mk.blog.shammy.business.articles.service.ISeoKeywordService;
import com.mk.blog.shammy.framework.controller.PaginatedListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements IArticleService {
    private final IArticleRepository repository;
    private final ArticleAdapter adapter;


    @Autowired
    public ArticleService(IArticleRepository repository, ArticleAdapter adapter) {
        this.repository = repository;
        this.adapter = adapter;
    }

    @Override
    public ArticleDTO save(ArticleDTO article) {
        return adapter.getDto(repository.save(adapter.getEntity(article)));
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
    public Optional<ArticleDTO> getArticleById(long id) {
        Optional<ArticleEntity> entity = repository.findById(id);
        ArticleDTO dto = null;
        if (entity.isPresent()) {
            dto = adapter.getDto(entity.get());
        }
        return dto == null ? Optional.empty() : Optional.of(dto);
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }


}
