package com.mk.blog.shammy.framework.controller;


public class DataResponse<T> {
    private StatusResponse status;
    private T data;
    private ErrorResponse error;


    public StatusResponse getStatus() {
        return status;
    }

    public void setStatus(StatusResponse status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}
