package com.mk.blog.shammy.defaultcorporate.authors.service;

import com.mk.blog.shammy.business.authors.adapter.AuthorAdapter;
import com.mk.blog.shammy.business.authors.dto.AuthorDTO;
import com.mk.blog.shammy.business.authors.model.AuthorEntity;
import com.mk.blog.shammy.business.authors.repository.IAuthorRepository;
import com.mk.blog.shammy.business.authors.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements IAuthorService {
    @Autowired
    private IAuthorRepository repository;
    @Autowired
    private AuthorAdapter adapter;
    @Override
    public Optional<AuthorDTO> getAuthorById(long id) {
        Optional<AuthorEntity> authorEntity = repository.findById(id);
        if(authorEntity.isPresent()){
          return Optional.of(adapter.getDto(authorEntity.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<AuthorDTO> getAuthors() {
        List<AuthorDTO> authors = new ArrayList<>();
        repository.findAll().forEach(entity->{authors.add(adapter.getDto(entity));});
        return authors;
    }

    @Override
    public void save(AuthorDTO author) {
        repository.save(adapter.getEntity(author));
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
