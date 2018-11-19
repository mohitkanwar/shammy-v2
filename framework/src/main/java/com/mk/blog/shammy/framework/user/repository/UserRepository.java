package com.mk.blog.shammy.framework.user.repository;

import com.mk.blog.shammy.framework.user.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
    UserEntity findDefaultUserDetailsByUsername(String username);
}
