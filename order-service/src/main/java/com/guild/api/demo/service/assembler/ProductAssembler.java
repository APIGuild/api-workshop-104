package com.guild.api.demo.service.assembler;

import com.guild.api.demo.model.OrderModel;
import com.guild.api.demo.model.ProductModel;
import com.guild.api.demo.util.rxjava.AsyncResult;

import io.reactivex.functions.BiFunction;

public class ProductAssembler implements BiFunction<OrderModel, AsyncResult<ProductModel>, OrderModel> {
    @Override
    public OrderModel apply(OrderModel orderModel, AsyncResult<ProductModel> asyncResult) throws Exception {
        if (asyncResult.hasException()) {
            throw new RuntimeException("Product Error!", asyncResult.getException());
        }
        orderModel.setProduct(asyncResult.getValue());
        return orderModel;
    }
}
