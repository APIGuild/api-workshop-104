package com.guild.api.demo.service.model;

import com.guild.api.demo.model.LogisticsModel;
import com.guild.api.demo.model.ProductModel;
import com.guild.api.demo.model.UserModel;

import lombok.Data;

@Data
public class OrderContainer {
    private UserModel user;
    private LogisticsModel logistics;
    private ProductModel product;
}
