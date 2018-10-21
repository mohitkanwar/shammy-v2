package com.mk.blog.shammy.business.articles.dto;


import com.mk.blog.shammy.business.user.dto.UserDTO;
import lombok.Data;


import java.time.LocalDate;

@Data
public class ArticleDTO {
    private Long id;
    private String title;
    private String body;
    private String summary;
    private UserDTO author;
    private LocalDate createDate;
    private LocalDate lastModifiedDate;
    private String tags;
    private String category;
}
