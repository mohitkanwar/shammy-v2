package com.mk.blog.shammy.defaultcorporate.articles.service;

import com.mk.blog.shammy.business.articles.adapter.ArticleAdapter;
import com.mk.blog.shammy.business.articles.dto.ArticleDTO;
import com.mk.blog.shammy.business.articles.model.ArticleEntity;
import com.mk.blog.shammy.business.articles.repository.IArticleRepository;
import com.mk.blog.shammy.business.articles.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements IArticleService {
    @Autowired
    private IArticleRepository repository;
    @Autowired
    private ArticleAdapter adapter;

    @Override
    public void save(ArticleDTO article) {
        repository.save(adapter.getEntity(article));
    }

    @Override
    public List<ArticleDTO> getArticles() {
        List<ArticleDTO> articlesList = new ArrayList<>();
        repository.findAll().forEach(entity -> {
            articlesList.add(adapter.getDto(entity));
        });
        return articlesList;
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
