package com.guild.api.demo.controller.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Order Data")
@JsonPropertyOrder({"title", "time"})
@JsonInclude(NON_EMPTY)
public class OrderDto {
    @ApiModelProperty(value = "Order Title", example = "My Order")
    private String title;

    @ApiModelProperty(value = "Order Time", example = "2017-10-20 10:42:55")
    private String time;

    @ApiModelProperty(value = "Customer Id", example = "123456789")
    private String customerId;

    @ApiModelProperty(value = "Logistics Id", example = "abc1234356xyz")
    private String logisticsId;

    @ApiModelProperty(value = "Order Description", example = "Description")
    private String description;

    public OrderDto(String title, String time, String customerId, String logisticsId) {
        this.title = title;
        this.time = time;
        this.customerId = customerId;
        this.logisticsId = logisticsId;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getLogisticsId() {
        return logisticsId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
