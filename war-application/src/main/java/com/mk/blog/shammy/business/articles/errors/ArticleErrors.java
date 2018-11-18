package com.mk.blog.shammy.business.articles.errors;

public enum ArticleErrors {
    ARTICLE_NOT_FOUND_WITH_ID("The article with provided Id doesn't exists");



    private String description;
    ArticleErrors(String description){
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
