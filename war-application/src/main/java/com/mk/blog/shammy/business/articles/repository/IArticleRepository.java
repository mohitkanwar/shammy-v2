package com.mk.blog.shammy.business.articles.repository;

import com.mk.blog.shammy.business.articles.model.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IArticleRepository extends PagingAndSortingRepository<ArticleEntity, Long> {
public Page<ArticleEntity> findArticleEntitiesByPublishingStateIsNot(long publishingState, Pageable pageable);
}
