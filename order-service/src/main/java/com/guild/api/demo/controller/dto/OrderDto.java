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

    @ApiModelProperty(value = "Order Description", example = "Order Description")
    private String description;

    @ApiModelProperty(value = "User Description", example = "John Smith...")
    private String user;

    @ApiModelProperty(value = "Logistics Description", example = "sf-express...")
    private String logistics;

    @ApiModelProperty(value = "Product Description", example = "Mac Book 15...")
    private String product;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLogistics() {
        return logistics;
    }

    public void setLogistics(String logistics) {
        this.logistics = logistics;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
