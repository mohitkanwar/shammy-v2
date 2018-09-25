package com.mk.blog.shammy.business.authors.controller;


import com.mk.blog.shammy.business.authors.dto.AuthorDTO;
import com.mk.blog.shammy.business.authors.errors.AuthorErrors;
import com.mk.blog.shammy.business.authors.service.IAuthorService;
import com.mk.blog.shammy.business.user.dto.UserDTO;
import com.mk.blog.shammy.framework.controller.DataResponse;
import com.mk.blog.shammy.framework.controller.StatusResponse;
import com.mk.blog.shammy.framework.errors.Errors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


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
}
