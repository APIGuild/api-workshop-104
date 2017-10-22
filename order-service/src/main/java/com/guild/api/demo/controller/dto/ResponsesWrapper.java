package com.guild.api.demo.controller.dto;

import java.util.List;

public class ResponsesWrapper<T> {
    private List<ResourceDto<T>> data;

    public List<ResourceDto<T>> getData() {
        return data;
    }

    public void setData(List<ResourceDto<T>> data) {
        this.data = data;
    }
}
