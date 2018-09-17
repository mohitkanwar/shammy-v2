package com.mk.blog.shammy.defaultcorporate.articles.entity;

import com.mk.blog.shammy.business.articles.model.AbstractArticleEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "MASTER_ARTICLE")
public class ArticleEntity extends AbstractArticleEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private String body;
    private String summary;
    private String authorName;
    private String createDate;
    private String lastModifiedDate;
    private String tags;
    private String category;
}

