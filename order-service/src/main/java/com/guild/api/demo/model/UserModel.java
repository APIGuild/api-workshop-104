package com.guild.api.demo.model;

public class UserModel {
    private String userId;
    private String description;

    public UserModel(String userId, String description) {
        this.userId = userId;
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }
}
