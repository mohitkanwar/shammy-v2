package com.mk.blog.shammy.business.articles.repository;

import com.mk.blog.shammy.business.articles.model.SeoKeywordEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ISEOKeywordRepository extends CrudRepository<SeoKeywordEntity,Long> {
    Optional<SeoKeywordEntity> findByKeyword(String keyword);
}
