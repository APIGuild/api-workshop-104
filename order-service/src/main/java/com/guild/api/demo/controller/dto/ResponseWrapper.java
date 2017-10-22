package com.guild.api.demo.controller.dto;

public class ResponseWrapper<T> {
    private ResourceDto<T> data;

    public ResourceDto<T> getData() {
        return data;
    }

    public void setData(ResourceDto<T> data) {
        this.data = data;
    }
}
