package com.mk.blog.shammy.defaultcorporate.user.service;

import com.mk.blog.shammy.framework.controller.PaginatedListResponse;
import com.mk.blog.shammy.framework.user.adapter.UserAdapter;
import com.mk.blog.shammy.framework.user.dto.UserDTO;
import com.mk.blog.shammy.framework.user.model.UserEntity;
import com.mk.blog.shammy.framework.user.repository.UserRepository;
import com.mk.blog.shammy.framework.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserService implements IUserService {
    private final UserRepository repository;
    private final UserAdapter adapter;

    @Autowired
    public UserService(UserRepository repository, UserAdapter adapter) {
        this.repository = repository;
        this.adapter = adapter;
    }

    @Override
    public void save(UserDTO user) {
        repository.save(adapter.getEntity(user));
    }

    @Override
    public PaginatedListResponse<UserDTO> getUsers(int pageSize, int pageNumber, String sortBy) {
        List<UserDTO> userList = new ArrayList<>();
        PaginatedListResponse<UserDTO> response = new PaginatedListResponse<UserDTO>();
        Page<UserEntity> userPage = repository.findAll(PageRequest.of(pageNumber,pageSize, Sort.by(sortBy)));
        userPage
        .forEach(entity ->{
            userList.add(adapter.getDto(entity));
        });
        response.setTotalsize(userPage.getTotalElements());
        response.setDataList(userList);
        return response;
    }

    @Override
    public Optional<UserDTO> getUserById(long id) {
        Optional<UserEntity> entity = repository.findById(id);
        UserDTO dto = null;
        if (entity.isPresent()) {
            dto = adapter.getDto(entity.get());
        }
        return dto == null ? Optional.empty() : Optional.of(dto);
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
