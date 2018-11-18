package com.mk.blog.shammy.framework.adapters;

public interface DtoToEntityAdapter<Dto, Entity> {
    Entity getEntity(Dto dto);
}
