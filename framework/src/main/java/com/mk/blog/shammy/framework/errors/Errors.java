package com.mk.blog.shammy.framework.errors;

public enum Errors {
    WTF("Something unexpected happened!");


    private String description;
    Errors(String description){
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
