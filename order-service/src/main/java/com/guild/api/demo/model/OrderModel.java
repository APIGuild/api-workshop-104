package com.guild.api.demo.model;

public class OrderModel {
    private String orderId;
    private String orderTitle;
    private String orderTime;
    private String description;
    private CustomerModel customer;
    private LogisticsModel logistics;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public LogisticsModel getLogistics() {
        return logistics;
    }

    public void setLogistics(LogisticsModel logistics) {
        this.logistics = logistics;
    }
}
