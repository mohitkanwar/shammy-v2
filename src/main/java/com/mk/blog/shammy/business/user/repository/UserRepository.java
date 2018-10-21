package com.mk.blog.shammy.business.user.repository;

import com.mk.blog.shammy.business.user.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findDefaultUserDetailsByUsername(String username);
}
