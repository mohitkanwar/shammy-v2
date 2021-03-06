package com.mk.blog.shammy.framework.security.services;


import com.mk.blog.shammy.framework.user.adapter.UserAdapter;
import com.mk.blog.shammy.framework.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@Primary
public class DefaultUserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserAdapter userAdapter;

    @Autowired
    public DefaultUserDetailsServiceImpl(UserRepository userRepository, UserAdapter userAdapter) {
        this.userRepository = userRepository;
        this.userAdapter = userAdapter;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findDefaultUserDetailsByUsername(userName);
    }
}
