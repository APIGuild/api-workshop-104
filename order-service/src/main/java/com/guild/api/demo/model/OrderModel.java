package com.guild.api.demo.model;

public class OrderModel {
    private String orderId;
    private String orderTitle;
    private String orderTime;
    private String description;
    private UserModel user;
    private LogisticsModel logistics;
    private ProductModel product;

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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public LogisticsModel getLogistics() {
        return logistics;
    }

    public void setLogistics(LogisticsModel logistics) {
        this.logistics = logistics;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public ProductModel getProduct() {
        return product;
    }
}
