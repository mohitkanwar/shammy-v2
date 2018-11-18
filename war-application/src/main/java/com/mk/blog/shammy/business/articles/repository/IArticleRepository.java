package com.mk.blog.shammy.business.articles.repository;

import com.mk.blog.shammy.business.articles.model.ArticleEntity;
import org.springframework.data.repository.CrudRepository;

public interface IArticleRepository extends CrudRepository<ArticleEntity, Long> {

}
