package com.mk.blog.shammy.business.articles.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SEO_KEYWORDS")
public class SeoKeywordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String keyword;

    public SeoKeywordEntity() {
    }

    public SeoKeywordEntity(String s) {
        setKeyword(s);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword.toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeoKeywordEntity)) return false;
        SeoKeywordEntity entity = (SeoKeywordEntity) o;
        return getKeyword().equals(entity.getKeyword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKeyword());
    }
}
