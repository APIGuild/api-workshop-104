package com.guild.api.demo.service.assembler;


import com.guild.api.demo.model.LogisticsModel;
import com.guild.api.demo.service.model.OrderContainer;
import com.guild.api.demo.util.rxjava.AsyncResult;

import io.reactivex.functions.BiFunction;

public class LogisticsAssembler implements BiFunction<OrderContainer, AsyncResult<LogisticsModel>, OrderContainer> {
    @Override
    public OrderContainer apply(OrderContainer orderContainer, AsyncResult<LogisticsModel> logisticsModel) throws Exception {
        if (logisticsModel.hasException()) {
            throw new RuntimeException("Logistics Error!", logisticsModel.getException());
        }
        orderContainer.setLogistics(logisticsModel.getValue());
        return orderContainer;

    }
}
