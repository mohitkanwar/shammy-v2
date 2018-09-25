package com.mk.blog.shammy.business.authors.controller;

import com.mk.blog.shammy.business.authors.dto.AuthorDTO;
import com.mk.blog.shammy.business.authors.errors.AuthorErrors;
import com.mk.blog.shammy.business.authors.service.IAuthorService;
import com.mk.blog.shammy.framework.controller.DataResponse;
import com.mk.blog.shammy.framework.controller.ErrorResponse;
import com.mk.blog.shammy.framework.controller.ListResponse;
import com.mk.blog.shammy.framework.controller.StatusResponse;
import com.mk.blog.shammy.framework.errors.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private IAuthorService service;
    @GetMapping("/{id}")
    public DataResponse<AuthorDTO> getAuthorById(@PathVariable long id) {
        DataResponse<AuthorDTO> response = new DataResponse<>();

        try {
            Optional<AuthorDTO> authorById = service.getAuthorById(id);
            if (authorById.isPresent()) {
                AuthorDTO author = null;
                author = authorById.get();
                response.setData(author);
                response.setStatus(StatusResponse.SUCCESS);
            } else {
                ErrorResponse error = new ErrorResponse();
                error.setErrorCode(AuthorErrors.AUTHOR_NOT_FOUND_WITH_ID.toString());
                error.setAdditionalInfo(AuthorErrors.AUTHOR_NOT_FOUND_WITH_ID.getDescription());
                response.setError(error);
                response.setStatus(StatusResponse.FAILURE);
            }
        } catch (RuntimeException e) {
            ErrorResponse error = new ErrorResponse();
            error.setErrorCode(Errors.WTF.toString());
            error.setAdditionalInfo(Errors.WTF.getDescription());
            response.setError(error);
            response.setStatus(StatusResponse.FAILURE);
        }
        return response;
    }

    @GetMapping("/list")
    public ListResponse<AuthorDTO> getAuthors() {
        ListResponse<AuthorDTO> response = new ListResponse<>();
        try {
            List<AuthorDTO> authors = service.getAuthors();
            response.setStatus(StatusResponse.SUCCESS);
            response.setDataList(authors);
        } catch (RuntimeException e) {
            ErrorResponse error = new ErrorResponse();
            error.setErrorCode(Errors.WTF.toString());
            error.setAdditionalInfo(Errors.WTF.getDescription());
            response.setError(error);
            response.setStatus(StatusResponse.FAILURE);
            response.setDataList(new ArrayList<>());
        }
        return response;
    }

    @PostMapping
    public StatusResponse createAuthor(@RequestBody AuthorDTO author) {
        try {
            service.save(author);
            return StatusResponse.SUCCESS;
        } catch (RuntimeException e) {
            return StatusResponse.FAILURE;
        }
    }

    @DeleteMapping("/{id}")
    public StatusResponse deleteAuthor(@PathVariable long id) {
        try {
            service.delete(id);
            return StatusResponse.SUCCESS;
        } catch (RuntimeException e) {
            return StatusResponse.FAILURE;
        }
    }

    @PutMapping("/{id}")
    public StatusResponse updateAuthor(@RequestBody AuthorDTO article) {
        try {
            service.save(article);
            return StatusResponse.SUCCESS;
        } catch (RuntimeException e) {
            return StatusResponse.FAILURE;
        }
    }

}
