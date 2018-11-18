package com.mk.blog.shammy.business.articles;

import com.mk.blog.shammy.business.articles.controller.ArticleController;
import com.mk.blog.shammy.business.articles.dto.ArticleDTO;
import com.mk.blog.shammy.framework.user.dto.UserDTO;
import com.mk.blog.shammy.framework.controller.StatusResponse;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArticleIntegrationTest {
    @Autowired
    private ArticleController articleController;
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(2l);
        UserDTO authorDTO = new UserDTO();
        authorDTO.setId(3);
        articleDTO.setAuthor(authorDTO);
        articleDTO.setBody("Body");
        articleDTO.setCategory("Category");
        articleDTO.setCreateDate(LocalDate.now());
        articleDTO.setSummary("summary");

        StatusResponse response = this.restTemplate.postForObject("http://localhost:" + port + "/article", articleDTO,
                StatusResponse.class);
        Assertions.assertThat(response.equals(StatusResponse.SUCCESS));

        ArticleDTO articleFromController = this.restTemplate.getForObject("http://localhost:" + port + "/article/2",
                ArticleDTO.class);
        Assertions.assertThat(articleFromController.equals(articleDTO));

        this.restTemplate.delete("http://localhost:" + port + "/article/2");
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/article/2",
                ArticleDTO.class).equals(new ArticleDTO()));
    }
}
