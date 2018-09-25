package com.mk.blog.shammy.business.authors.errors;

public enum AuthorErrors {
    AUTHOR_NOT_FOUND_WITH_ID("The author with provided Id doesn't exists");



    private String description;
    AuthorErrors(String description){
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
