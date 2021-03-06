package com.mk.blog.shammy.business.articles.adapter;
import com.mk.blog.shammy.business.articles.model.SeoKeywordEntity;
import com.mk.blog.shammy.business.articles.repository.ISEOKeywordRepository;
import com.mk.blog.shammy.framework.adapters.DtoToEntityAdapter;
import com.mk.blog.shammy.framework.adapters.EntityToDtoAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeywordAdapter implements EntityToDtoAdapter<SeoKeywordEntity, String>, DtoToEntityAdapter<String, SeoKeywordEntity> {

    private final ISEOKeywordRepository keywordRepository;

    @Autowired
    public KeywordAdapter(ISEOKeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    @Override
    public SeoKeywordEntity getEntity(String s) {
        return this.keywordRepository.findByKeyword(s).orElse(new SeoKeywordEntity(s));
    }

    @Override
    public String getDto(SeoKeywordEntity d) {
        return d!=null?d.getKeyword():"";
    }
}
