package com.mk.blog.shammy.framework.user.repository;

import com.mk.blog.shammy.framework.user.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findDefaultUserDetailsByUsername(String username);
}
