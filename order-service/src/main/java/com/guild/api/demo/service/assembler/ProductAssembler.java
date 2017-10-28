package com.guild.api.demo.service.assembler;

import com.guild.api.demo.model.ProductModel;
import com.guild.api.demo.service.model.OrderContainer;
import com.guild.api.demo.util.rxjava.AsyncResult;

import io.reactivex.functions.BiFunction;

public class ProductAssembler implements BiFunction<OrderContainer, AsyncResult<ProductModel>, OrderContainer> {
    @Override
    public OrderContainer apply(OrderContainer orderContainer, AsyncResult<ProductModel> productModel) throws Exception {
        if (productModel.hasException()) {
            throw new RuntimeException("Product Error!", productModel.getException());
        }
        orderContainer.setProduct(productModel.getValue());
        return orderContainer;
    }
}
