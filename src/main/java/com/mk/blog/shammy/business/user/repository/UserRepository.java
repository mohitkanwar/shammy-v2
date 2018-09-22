package com.mk.blog.shammy.business.user.repository;

import com.mk.blog.shammy.business.user.model.DefaultUserDetails;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<DefaultUserDetails, Long> {
    DefaultUserDetails findDefaultUserDetailsByUsername(String username);
}
