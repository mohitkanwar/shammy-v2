package com.mk.blog.shammy.business.articles.model;

import com.mk.blog.shammy.business.user.model.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
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
}

