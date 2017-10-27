package com.guild.api.demo.service.assembler;


import com.guild.api.demo.model.LogisticsModel;
import com.guild.api.demo.model.OrderModel;
import com.guild.api.demo.util.rxjava.AsyncResult;

import io.reactivex.functions.BiFunction;

public class LogisticsAssembler implements BiFunction<OrderModel, AsyncResult<LogisticsModel>, OrderModel> {
    @Override
    public OrderModel apply(OrderModel orderModel, AsyncResult<LogisticsModel> asyncResult) throws Exception {
        if (asyncResult.hasException()) {
            throw new RuntimeException("Logistics Error!");
        }
        orderModel.setLogistics(asyncResult.getValue());
        return orderModel;

    }
}
