package com.mk.blog.shammy.framework.controller;

public enum StatusResponse {
    SUCCESS("success"), FAILURE("failure");
    private String status;

    StatusResponse(String s) {
        this.status = s;
    }

    @Override
    public String toString() {
        return "{" +
                "status='" + status + '\'' +
                '}';
    }
}
