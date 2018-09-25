package com.mk.blog.shammy.business.user.adapter;

import com.mk.blog.shammy.business.authors.model.AuthorEntity;
import com.mk.blog.shammy.business.user.dto.AuthorityDTO;
import com.mk.blog.shammy.business.user.dto.UserDTO;
import com.mk.blog.shammy.business.user.model.DefaultAuthority;
import com.mk.blog.shammy.business.user.model.DefaultUserDetails;
import com.mk.blog.shammy.framework.adapters.DtoToEntityAdapter;
import com.mk.blog.shammy.framework.adapters.EntityToDtoAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserAdapter  implements EntityToDtoAdapter<DefaultUserDetails, UserDTO>, DtoToEntityAdapter<UserDTO, DefaultUserDetails> {
    @Override
    public DefaultUserDetails getEntity(UserDTO userDTO) {
        DefaultUserDetails entity = new DefaultUserDetails();
        entity.setLastName(userDTO.getLastName());
        entity.setFirstName(userDTO.getFirstName());
        entity.setUsername(userDTO.getUsername());
        entity.setPassword(userDTO.getPassword());
        entity.setEnabled(userDTO.isEnabled());
        entity.setCredentialsNonExpired(userDTO.isCredentialsNonExpired());
        entity.setAccountNonLocked(userDTO.isAccountNonLocked());
        entity.setId(userDTO.getId());
        entity.setAccountNonExpired(userDTO.isAccountNonExpired());
        List<DefaultAuthority> authorities = userDTO.getAuthorities().stream().map(dto->{
            DefaultAuthority authority = new DefaultAuthority();
            authority.setDescription(dto.getDescription());
            authority.setId(dto.getId());
            authority.setAuthority(dto.getAuthority());
            return authority;
        }).collect(Collectors.toList());
        entity.setAuthorities(authorities);
        return entity;
    }

    @Override
    public UserDTO getDto(DefaultUserDetails d) {
        UserDTO userDTO = new UserDTO();
        userDTO.setLastName(d.getLastName());
        userDTO.setFirstName(d.getFirstName());
        userDTO.setUsername(d.getUsername());
        userDTO.setPassword(d.getPassword());
        userDTO.setEnabled(d.isEnabled());
        userDTO.setCredentialsNonExpired(d.isCredentialsNonExpired());
        userDTO.setAccountNonLocked(d.isAccountNonLocked());
        userDTO.setId(d.getId());
        userDTO.setAccountNonExpired(d.isAccountNonExpired());
        List<AuthorityDTO> authorities = d.getAuthorities().stream().map(entity->{
            AuthorityDTO authority = new AuthorityDTO();
            authority.setDescription(entity.getDescription());
            authority.setId(entity.getId());
            authority.setAuthority(entity.getAuthority());
            return authority;
        }).collect(Collectors.toList());
        userDTO.setAuthorities(authorities);
        return userDTO;
    }
}
