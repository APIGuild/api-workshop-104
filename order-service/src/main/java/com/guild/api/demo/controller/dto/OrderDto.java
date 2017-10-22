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

    @ApiModelProperty(value = "Order Description", example = "Description")
    private String description;

    @ApiModelProperty(value = "Customer Description", example = "Customer")
    private String customer;

    @ApiModelProperty(value = "Logistics Description", example = "Logistics")
    private String logistics;

    public OrderDto(String title, String time, String customer, String logistics) {
        this.title = title;
        this.time = time;
        this.customer = customer;
        this.logistics = logistics;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getCustomer() {
        return customer;
    }

    public String getLogistics() {
        return logistics;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
