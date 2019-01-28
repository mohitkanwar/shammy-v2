package com.mk.blog.shammy.business.articles.model;

import com.mk.blog.shammy.business.articles.publishing.PublishingState;
import com.mk.blog.shammy.framework.user.model.UserEntity;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ARTICLES")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;
    private String summary;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity author;
    private LocalDate createDate;
    private LocalDate lastModifiedDate;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany()
    @JoinTable(name = "ARTICLE_SEO_KEYWORDS", joinColumns = { @JoinColumn(name = "ARTICLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "KEYWORD_ID") })
    private Set<SeoKeywordEntity> seoKeywords;
    private String category;
    private Long publishingState;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Set<SeoKeywordEntity> getSeoKeywords() {
        return seoKeywords;
    }

    public void setSeoKeywords(Set<SeoKeywordEntity> seoKeywords) {
        this.seoKeywords = seoKeywords;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleEntity)) return false;
        ArticleEntity that = (ArticleEntity) o;
        if(getId() == null && that.getId() == null){
            return  Objects.equals(getTitle(), that.getTitle()) &&
                    Objects.equals(getBody(), that.getBody()) &&
                    Objects.equals(getSummary(), that.getSummary()) &&
                    Objects.equals(getAuthor(), that.getAuthor()) &&
                    Objects.equals(getCreateDate(), that.getCreateDate()) &&
                    Objects.equals(getLastModifiedDate(), that.getLastModifiedDate()) &&
                    Objects.equals(getSeoKeywords(), that.getSeoKeywords()) &&
                    Objects.equals(getCategory(), that.getCategory());
        }else{
            return Objects.equals(getId(),that.getId());
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getBody(), getSummary(), getAuthor(), getCreateDate(), getLastModifiedDate(), getSeoKeywords(), getCategory());
    }

    public PublishingState getPublishingState() {
       return PublishingState.valueOf(this.publishingState);
    }

    public void setPublishingState(PublishingState publishingState) {
        this.publishingState=(publishingState==null)?null: publishingState.getId();
    }
}

