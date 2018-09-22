package com.mk.blog.shammy.framework.controller;

import lombok.Data;

@Data
public class DataResponse<T> {
    private StatusResponse status;
    private T data;
    private ErrorResponse error;
}
