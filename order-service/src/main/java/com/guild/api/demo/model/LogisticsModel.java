package com.guild.api.demo.model;

public class LogisticsModel {
    private String logisticsId;
    private String description;

    public LogisticsModel(String logisticsId, String description) {
        this.logisticsId = logisticsId;
        this.description = description;
    }

    public String getLogisticsId() {
        return logisticsId;
    }

    public String getDescription() {
        return description;
    }
}
