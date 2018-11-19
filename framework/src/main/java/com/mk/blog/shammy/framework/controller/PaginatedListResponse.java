package com.mk.blog.shammy.framework.controller;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginatedListResponse<T> {
    private List<T> dataList;
    private long totalsize;
    private int pageNumber;
    private int pageSize;
    private StatusResponse status;

    public void setError(ErrorResponse error) {
        if(error!=null){
            this.error = error;
            this.status = StatusResponse.FAILURE;
        }

    }

    private ErrorResponse error;


    public PaginatedListResponse() {
        this.status = StatusResponse.FAILURE;
        this.dataList = new ArrayList<>();
    }

    public void setDataList(final List<T> dataList) {
        this.dataList = dataList == null ? new ArrayList<>(0) : dataList;
    }
}
