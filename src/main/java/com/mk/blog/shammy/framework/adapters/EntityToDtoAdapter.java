package com.mk.blog.shammy.framework.adapters;

public interface EntityToDto<Entity, Dto> {
    Entity getEntity(Dto d);
}
