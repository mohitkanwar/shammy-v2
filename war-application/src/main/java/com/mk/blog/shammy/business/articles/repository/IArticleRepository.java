package com.mk.blog.shammy.business.articles.repository;

import com.mk.blog.shammy.business.articles.model.ArticleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IArticleRepository extends PagingAndSortingRepository<ArticleEntity, Long> {

}
