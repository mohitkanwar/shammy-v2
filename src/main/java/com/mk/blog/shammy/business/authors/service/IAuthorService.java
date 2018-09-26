package com.mk.blog.shammy.business.authors.service;

import com.mk.blog.shammy.business.authors.dto.AuthorDTO;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {
    Optional<AuthorDTO> getAuthorById(long id);

    List<AuthorDTO> getAuthors();

    void save(AuthorDTO author);

    void delete(long id);
}
