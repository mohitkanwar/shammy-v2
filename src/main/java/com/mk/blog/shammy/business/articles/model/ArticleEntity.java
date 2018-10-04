package com.mk.blog.shammy.business.articles.model;

import com.mk.blog.shammy.business.authors.model.AuthorEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "MASTER_ARTICLE")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String body;
    private String summary;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private AuthorEntity author;
    private String createDate;
    private String lastModifiedDate;
    private String tags;
    private String category;
}

