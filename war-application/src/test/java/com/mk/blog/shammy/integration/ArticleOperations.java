package com.mk.blog.shammy.integration;

import com.mk.blog.shammy.business.articles.controller.ArticleController;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Category(Integration.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleOperations {
    @Autowired
    private ArticleController articleController;

    @Test
    public void testArticleCreation(){

    }
}
