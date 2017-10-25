package com.guild.api.demo.model;

public class ProductModel {
    private final String productId;
    private final String description;

    public ProductModel(String productId, String description) {
        this.productId = productId;
        this.description = description;
    }

    public String getProductId() {
        return productId;
    }

    public String getDescription() {
        return description;
    }
}
