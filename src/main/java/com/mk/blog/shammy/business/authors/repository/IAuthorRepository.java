package com.mk.blog.shammy.business.authors.repository;

import com.mk.blog.shammy.business.articles.model.ArticleEntity;
import com.mk.blog.shammy.business.authors.model.AuthorEntity;
import org.springframework.data.repository.CrudRepository;

public interface IAuthorRepository extends CrudRepository<AuthorEntity, Long> {

}
