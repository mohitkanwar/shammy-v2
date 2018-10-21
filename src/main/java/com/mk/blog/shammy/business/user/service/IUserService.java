package com.mk.blog.shammy.business.user.service;


import com.mk.blog.shammy.business.user.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    void save(UserDTO user);

    List<UserDTO> getUsers();

    Optional<UserDTO> getUserById(long id);

    void delete(long id);
}
