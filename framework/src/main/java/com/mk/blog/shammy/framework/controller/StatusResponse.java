package com.mk.blog.shammy.framework.controller;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusResponse that = (StatusResponse) o;
        return Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(status);
    }
}
