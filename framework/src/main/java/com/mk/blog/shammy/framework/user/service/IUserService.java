package com.mk.blog.shammy.framework.user.service;



import com.mk.blog.shammy.framework.controller.PaginatedListResponse;
import com.mk.blog.shammy.framework.user.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    void save(UserDTO user);

    PaginatedListResponse<UserDTO> getUsers(int pageSize, int pageNumber, String sortBy);

    Optional<UserDTO> getUserById(long id);

    void delete(long id);
}
