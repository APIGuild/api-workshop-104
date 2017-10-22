package com.guild.api.demo.model;

public class CustomerModel {
    private String customerId;
    private String description;

    public CustomerModel(String customerId, String description) {
        this.customerId = customerId;
        this.description = description;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getDescription() {
        return description;
    }
}
