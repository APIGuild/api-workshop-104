package com.guild.api.demo.service.assembler;

import com.guild.api.demo.model.OrderModel;
import com.guild.api.demo.model.UserModel;
import com.guild.api.demo.util.rxjava.AsyncResult;

import io.reactivex.functions.BiFunction;

public class UserAssembler implements BiFunction<OrderModel, AsyncResult<UserModel>, OrderModel> {
    @Override
    public OrderModel apply(OrderModel orderModel, AsyncResult<UserModel> asyncResult) throws Exception {
        if (asyncResult.hasException()) {
            throw new RuntimeException("User Error!", asyncResult.getException());
        }
        orderModel.setUser(asyncResult.getValue());
        return orderModel;
    }
}
