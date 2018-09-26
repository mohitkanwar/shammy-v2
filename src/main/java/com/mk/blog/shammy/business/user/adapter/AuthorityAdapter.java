package com.mk.blog.shammy.business.user.adapter;

import com.mk.blog.shammy.business.user.dto.AuthorityDTO;
import com.mk.blog.shammy.business.user.model.DefaultAuthority;
import com.mk.blog.shammy.framework.adapters.DtoToEntityAdapter;
import com.mk.blog.shammy.framework.adapters.EntityToDtoAdapter;
import org.springframework.stereotype.Component;

@Component
public class AuthorityAdapter  implements EntityToDtoAdapter<DefaultAuthority, AuthorityDTO>, DtoToEntityAdapter<AuthorityDTO, DefaultAuthority> {
    @Override
    public DefaultAuthority getEntity(AuthorityDTO dto) {
        DefaultAuthority authority = new DefaultAuthority();
        authority.setDescription(dto.getDescription());
        authority.setId(dto.getId());
        authority.setAuthority(dto.getAuthority());
        return authority;
    }

    @Override
    public AuthorityDTO getDto(DefaultAuthority entity) {
        AuthorityDTO authority = new AuthorityDTO();
        authority.setDescription(entity.getDescription());
        authority.setId(entity.getId());
        authority.setAuthority(entity.getAuthority());
        return authority;
    }
}
