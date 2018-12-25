package com.mk.blog.shammy.framework.controller;

public class StatusResponse {
    public static final StatusResponse SUCCESS = new StatusResponse("SUCCESS");
    public static final StatusResponse FAILURE = new StatusResponse("FAILURE");

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    private StatusResponse(String s) {
        this.status = s;
    }

}
