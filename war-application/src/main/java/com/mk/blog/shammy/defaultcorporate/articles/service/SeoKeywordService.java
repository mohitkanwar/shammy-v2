package com.mk.blog.shammy.defaultcorporate.articles.service;

import com.mk.blog.shammy.business.articles.adapter.KeywordAdapter;
import com.mk.blog.shammy.business.articles.model.SeoKeywordEntity;
import com.mk.blog.shammy.business.articles.repository.ISEOKeywordRepository;
import com.mk.blog.shammy.business.articles.service.ISeoKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeoKeywordService implements ISeoKeywordService {

    private final ISEOKeywordRepository seoKeywordRepository;

    private final KeywordAdapter keywordAdapter;

    @Autowired
    public SeoKeywordService(ISEOKeywordRepository seoKeywordRepository, KeywordAdapter keywordAdapter) {
        this.seoKeywordRepository = seoKeywordRepository;
        this.keywordAdapter = keywordAdapter;
    }

    @Override
    public String save(String keyword) {
        Optional<SeoKeywordEntity> keywordEntityOptional = seoKeywordRepository.findByKeyword(keyword);
        SeoKeywordEntity entity = null;
        if(!keywordEntityOptional.isPresent()){
            entity = seoKeywordRepository.save(keywordAdapter.getEntity(keyword));
        }
        return keywordAdapter.getDto(keywordEntityOptional.orElse(entity));
    }
}
