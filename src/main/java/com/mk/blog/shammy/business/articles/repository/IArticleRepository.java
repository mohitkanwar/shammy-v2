package com.mk.blog.shammy.articles.repository;

import com.mk.blog.shammy.articles.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository  extends CrudRepository<Article, Long> {

}
