package com.mk.blog.shammy.framework.controller;


import java.util.ArrayList;
import java.util.List;

public class PaginatedListResponse<T> {
    private List<T> dataList;
    private long totalsize;
    private int pageNumber;
    private int pageSize;
    private StatusResponse status;
    private ErrorResponse error;


    public List<T> getDataList() {
        return dataList;
    }

    public long getTotalsize() {
        return totalsize;
    }

    public void setTotalsize(long totalsize) {
        this.totalsize = totalsize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public StatusResponse getStatus() {
        return status;
    }

    public void setStatus(StatusResponse status) {
        this.status = status;
    }

    public ErrorResponse getError() {
        return error;
    }


    public void setError(ErrorResponse error) {
        if(error!=null){
            this.error = error;
            this.status = StatusResponse.FAILURE;
        }

    }


    public PaginatedListResponse() {
        this.status = StatusResponse.FAILURE;
        this.dataList = new ArrayList<>();
    }

    public void setDataList(final List<T> dataList) {
        this.dataList = dataList == null ? new ArrayList<>(0) : dataList;
    }
}
