package com.mk.blog.shammy.defaultcorporate.user.service;

import com.mk.blog.shammy.framework.user.adapter.UserAdapter;
import com.mk.blog.shammy.framework.user.dto.UserDTO;
import com.mk.blog.shammy.framework.user.model.UserEntity;
import com.mk.blog.shammy.framework.user.repository.UserRepository;
import com.mk.blog.shammy.framework.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<UserDTO> getUsers() {
        List<UserDTO> userList = new ArrayList<>();
        repository.findAll().forEach(entity -> userList.add(adapter.getDto(entity)));
        return userList;
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
