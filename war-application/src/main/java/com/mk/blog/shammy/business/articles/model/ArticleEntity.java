package com.mk.blog.shammy.business.articles.model;

import com.mk.blog.shammy.framework.user.model.UserEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ARTICLES")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String body;
    private String summary;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity author;
    private LocalDate createDate;
    private LocalDate lastModifiedDate;
    private String tags;
    private String category;

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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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
                    Objects.equals(getTags(), that.getTags()) &&
                    Objects.equals(getCategory(), that.getCategory());
        }else{
            return Objects.equals(getId(),that.getId());
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getBody(), getSummary(), getAuthor(), getCreateDate(), getLastModifiedDate(), getTags(), getCategory());
    }
}

