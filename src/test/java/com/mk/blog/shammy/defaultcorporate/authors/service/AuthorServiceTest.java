package com.mk.blog.shammy.defaultcorporate.authors.service;

import com.mk.blog.shammy.business.articles.model.ArticleEntity;
import com.mk.blog.shammy.business.authors.dto.AuthorDTO;
import com.mk.blog.shammy.business.authors.model.AuthorEntity;
import com.mk.blog.shammy.business.authors.repository.IAuthorRepository;
import com.mk.blog.shammy.business.authors.service.IAuthorService;
import com.mk.blog.shammy.business.user.dto.UserDTO;
import com.mk.blog.shammy.business.user.model.DefaultAuthority;
import com.mk.blog.shammy.business.user.model.DefaultUserDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthorServiceTest {
    @Autowired
    private IAuthorService service;
    @MockBean
    private IAuthorRepository repository;

    @Test
    public void getAuthorById() {
        AuthorEntity mockAuthor = new AuthorEntity();
        DefaultUserDetails userDetails = new DefaultUserDetails();
        userDetails.setId(1);
        List<ArticleEntity> articleList = new ArrayList<>();
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setTags("None");
        articleEntity.setLastModifiedDate(new Date().toString());
        articleEntity.setSummary("summary");
        articleEntity.setTitle("title");
        articleEntity.setCreateDate(new Date().toString());
        articleEntity.setCategory("category");
        articleEntity.setBody("The article Body");
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setArticles(new ArrayList<>());
        authorEntity.setUserDetails(new DefaultUserDetails());
        articleEntity.setAuthor(authorEntity);
        articleEntity.setId(1l);
        articleList.add(articleEntity);
        mockAuthor.setArticles(articleList);
        userDetails.setAccountNonExpired(true);
        List<DefaultAuthority> authorities = new ArrayList<>();
        DefaultAuthority defAuthority = new DefaultAuthority();
        defAuthority.setAuthority("AUTH");
        defAuthority.setId(1);
        defAuthority.setDescription("Auth authority");
        authorities.add(defAuthority);
        userDetails.setAuthorities(authorities);
        userDetails.setId(1);
        userDetails.setAccountNonLocked(true);
        userDetails.setCredentialsNonExpired(true);
        userDetails.setEnabled(true);
        userDetails.setPassword("password");
        userDetails.setUsername("uname");
        userDetails.setFirstName("Fname");
        userDetails.setLastName("Lname");
        userDetails.setEnabled(true);
        mockAuthor.setUserDetails(userDetails);
        mockAuthor.setId(1l);
        Optional<AuthorEntity> mockEntity = Optional.of(mockAuthor);
        when(repository.findById(1l)).thenReturn(mockEntity);
        Optional<AuthorDTO> optionalauthorDTO= service.getAuthorById(1);
        assertTrue(optionalauthorDTO.isPresent());
        AuthorDTO dto = optionalauthorDTO.get();
        assertEquals(dto.getArticles().size(),articleList.size());
        assertEquals(dto.getArticles().get(0).getId(),articleList.get(0).getId());
        assertEquals(dto.getUserDTO().getId(),mockAuthor.getUserDetails().getId());

    }

    @Test
    public void getEmptyAuthor(){
        when(repository.findById(1l)).thenReturn(Optional.empty());
       Optional<AuthorDTO> authorDTO = service.getAuthorById(1l);
       assertEquals(Optional.empty(),authorDTO);
    }

    @Test
    public void getAuthors(){
        List<AuthorEntity> authors = new ArrayList<>();
        AuthorEntity author = new AuthorEntity();
        author.setId(20l);
        author.setUserDetails(new DefaultUserDetails());
        author.setArticles(new ArrayList<>());
        authors.add(author);

        when(repository.findAll()).thenReturn(authors);
        List<AuthorDTO> authorsResult = service.getAuthors();
        assertEquals(1,authorsResult.size());
        assertEquals(20l,authorsResult.get(0).getId());
    }
    @Test
    public void saveAuthors(){
        when(repository.save(any(AuthorEntity.class))).thenReturn(new AuthorEntity());
        AuthorDTO author = new AuthorDTO();
        UserDTO userDTO = new UserDTO();
        userDTO.setAuthorities(new ArrayList<>());
        author.setUserDTO(userDTO);
        author.setArticles(new ArrayList<>());
        service.save(author);
    }
    @Test
    public void deleteAuthors(){
        doNothing().when(repository).deleteById(1l);
        service.delete(1l);
    }
}