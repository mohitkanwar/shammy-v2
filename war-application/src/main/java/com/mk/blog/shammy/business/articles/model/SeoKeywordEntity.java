package com.mk.blog.shammy.business.articles.model;

import javax.persistence.*;

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
        this.keyword = s;
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
        this.keyword = keyword;
    }
}
