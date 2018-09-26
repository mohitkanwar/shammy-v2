package com.mk.blog.shammy.business.authors.controller;



import com.mk.blog.shammy.business.authors.dto.AuthorDTO;
import com.mk.blog.shammy.business.authors.errors.AuthorErrors;
import com.mk.blog.shammy.business.authors.service.IAuthorService;
import com.mk.blog.shammy.business.user.dto.UserDTO;
import com.mk.blog.shammy.framework.controller.DataResponse;
import com.mk.blog.shammy.framework.controller.ListResponse;
import com.mk.blog.shammy.framework.controller.StatusResponse;
import com.mk.blog.shammy.framework.errors.Errors;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorsControllerTest {
    @Autowired
    private AuthorController controller;
    @MockBean
    private IAuthorService service;

    @Test
    public void getAuthorById() {
        AuthorDTO mockAuthor = new AuthorDTO();
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1l);
        userDTO.setFirstName("Mock Title");
        mockAuthor.setUserDTO(userDTO);
        Optional<AuthorDTO> optionalAuthorDTO = Optional.of(mockAuthor);
        when(service.getAuthorById(1l)).thenReturn(optionalAuthorDTO);
        DataResponse<AuthorDTO> articleResponse = controller.getAuthorById(1);
        assertEquals(StatusResponse.SUCCESS,articleResponse.getStatus());
        assertEquals(mockAuthor, articleResponse.getData());
    }

    @Test
    public void testAuthorNotExisting() {
        Optional<AuthorDTO> optionalAuthorDTO = Optional.empty();
        when(service.getAuthorById(1)).thenReturn(optionalAuthorDTO);
        DataResponse<AuthorDTO> authorResponse = controller.getAuthorById(1);
        assertEquals(StatusResponse.FAILURE,authorResponse.getStatus());
        assertEquals(AuthorErrors.AUTHOR_NOT_FOUND_WITH_ID.toString(), authorResponse.getError().getErrorCode());
    }
    @Test
    public void testExceptioninGetById() {
        when(service.getAuthorById(1)).thenThrow(new NullPointerException());
        DataResponse<AuthorDTO> authorResponse = controller.getAuthorById(1);
        assertEquals(StatusResponse.FAILURE,authorResponse.getStatus());
        assertEquals(Errors.WTF.toString(), authorResponse.getError().getErrorCode());
    }

    @Test
    public void getAuthors() {
        AuthorDTO mockAuthor = new AuthorDTO();
        mockAuthor.setId(1l);
        UserDTO user = new UserDTO();
        user.setFirstName("fname");
        user.setId(1);
        mockAuthor.setUserDTO(user);
        List<AuthorDTO> authors = new ArrayList<>();
        authors.add(mockAuthor);
        Mockito.when(service.getAuthors()).thenReturn(authors);
        ListResponse<AuthorDTO> response = controller.getAuthors();
        Assert.assertEquals(StatusResponse.SUCCESS, response.getStatus());
        Assert.assertEquals(authors, response.getDataList());
        Assert.assertEquals(1, response.getSize());
    }
    @Test
    public void getAuthorsExceptionCase() {
        AuthorDTO mockAuthor = new AuthorDTO();
        mockAuthor.setId(1l);
        UserDTO user = new UserDTO();
        user.setFirstName("fname");
        user.setId(1);
        mockAuthor.setUserDTO(user);
        List<AuthorDTO> authors = new ArrayList<>();
        authors.add(mockAuthor);
        Mockito.when(service.getAuthors()).thenThrow( new NullPointerException());
        ListResponse<AuthorDTO> response = controller.getAuthors();
        Assert.assertEquals(StatusResponse.FAILURE, response.getStatus());
        Assert.assertEquals(Errors.WTF.toString(), response.getError().getErrorCode());
    }

    @Test
    public void createAuthor() {
        AuthorDTO mockAuthor = new AuthorDTO();
        mockAuthor.setId(1l);
        UserDTO user = new UserDTO();
        mockAuthor.setUserDTO(user);
        Mockito.doNothing().when(service).save(mockAuthor);
        StatusResponse response = controller.createAuthor(mockAuthor);
        Assert.assertEquals(StatusResponse.SUCCESS, response);
    }

    @Test
    public void createAuthorExceptionCase() {
        AuthorDTO mockAuthor = new AuthorDTO();
        mockAuthor.setId(1l);
        mockAuthor.setUserDTO(new UserDTO());
        Mockito.doThrow(new NullPointerException()).when(service).save(mockAuthor);
        StatusResponse response = controller.createAuthor(mockAuthor);
        Assert.assertEquals(StatusResponse.FAILURE, response);
    }

    @Test
    public void deleteAuthor() {
        AuthorDTO mockAuthor = new AuthorDTO();
        mockAuthor.setId(1l);
        Mockito.doNothing().when(service).delete(1l);
        StatusResponse response = controller.deleteAuthor(1l);
        Assert.assertEquals(StatusResponse.SUCCESS, response);
    }

    @Test
    public void deleteAuthorException() {
        AuthorDTO mockAuthor = new AuthorDTO();
        mockAuthor.setId(1l);
        Mockito.doThrow(new NullPointerException()).when(service).delete(1l);
        StatusResponse response = controller.deleteAuthor(1l);
        Assert.assertEquals(StatusResponse.FAILURE, response);
    }

    @Test
    public void updateAuthor() {
        AuthorDTO mockAuthor = new AuthorDTO();
        mockAuthor.setId(1l);
        Mockito.doNothing().when(service).save(mockAuthor);
        StatusResponse response = controller.updateAuthor(mockAuthor);
        Assert.assertEquals(StatusResponse.SUCCESS, response);
    }

    @Test
    public void updateAuthorException() {
        AuthorDTO mockAuthor = new AuthorDTO();
        mockAuthor.setId(1l);
        Mockito.doThrow(new NullPointerException()).when(service).save(mockAuthor);
        StatusResponse response = controller.updateAuthor(mockAuthor);
        Assert.assertEquals(StatusResponse.FAILURE, response);
    }
}
