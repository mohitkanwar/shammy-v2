package com.mk.blog.shammy.business.user.errors;

public enum UserErrors {
    USER_NOT_FOUND_WITH_ID("The article with provided Id doesn't exists");



    private String description;
    UserErrors(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    public String getDescription() {
        return description;
    }
}
