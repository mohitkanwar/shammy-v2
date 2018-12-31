package com.mk.blog.shammy.defaultcorporate.articles.service;

import com.mk.blog.shammy.business.articles.adapter.KeywordAdapter;
import com.mk.blog.shammy.business.articles.repository.ISEOKeywordRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SeoKeywordServiceTest {

    @Autowired
    private SeoKeywordService seoKeywordService;
    @MockBean
    private ISEOKeywordRepository seoKeywordRepository;
    @MockBean
    private KeywordAdapter keywordAdapter;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void save() {
        String keyword = seoKeywordService.save("Test");
    }
}