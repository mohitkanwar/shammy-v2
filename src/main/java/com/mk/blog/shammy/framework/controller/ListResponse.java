package com.mk.blog.shammy.framework.controller;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListResponse<T> {
    private List<T> dataList;
    private int size;
    private StatusResponse status;
    private ErrorResponse error;

    public void setDataList(final List<T> dataList) {
        this.dataList = dataList == null ? new ArrayList<>(0) : dataList;
        this.setSize(dataList == null ? 0 : dataList.size());
    }

    private void setSize(int size) {
        this.size = size;
    }
}
