package com.mk.blog.shammy.defaultcorporate.articles.dto;

import com.mk.blog.shammy.business.articles.dto.AbstractArticleDto;
import lombok.Data;

@Data
public class ArticleDTO extends AbstractArticleDto {
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