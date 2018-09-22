package com.mk.blog.shammy.framework.controller;

import lombok.Data;

@Data
public class ErrorResponse {
    private String errorCode;
    private String additionalInfo;
}
