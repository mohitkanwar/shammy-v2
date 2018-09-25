package com.mk.blog.shammy.business.authors.model;

import com.mk.blog.shammy.business.articles.model.ArticleEntity;
import com.mk.blog.shammy.business.user.model.DefaultUserDetails;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "MASTER_AUTHOR")
public class AuthorEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private DefaultUserDetails userDetails;
    @OneToMany
    @JoinTable(name = "AUTHOR_ARTICLES",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "article_id")}
    )
    private List<ArticleEntity> articles;

}

