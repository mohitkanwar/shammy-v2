package com.mk.blog.shammy.framework.adapters;

public interface EntityToDtoAdapter<Entity, Dto> {
    Dto getDto(Entity d);
}
