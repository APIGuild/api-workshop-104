package com.guild.api.demo.controller.translator;

import org.springframework.stereotype.Component;
import com.guild.api.demo.controller.dto.OrderDto;
import com.guild.api.demo.controller.dto.ResourceDto;
import com.guild.api.demo.controller.dto.ResponseWrapper;
import com.guild.api.demo.model.OrderModel;

@Component
public class OrderTranslator {
    public ResponseWrapper<OrderDto> translate(OrderModel order) {
        ResourceDto<OrderDto> resourceData = new ResourceDto<>();
        if (order != null) {
            resourceData.setAttributes(buildOrder(order));
            resourceData.setId(order.getOrderId());
        }
        return new ResponseWrapper<>(resourceData);
    }

    private OrderDto buildOrder(OrderModel order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setTitle(order.getOrderTitle());
        orderDto.setTime(order.getOrderTime());
        orderDto.setDescription(order.getDescription());
        orderDto.setUser(order.getUser().getDescription());
        orderDto.setLogistics(order.getLogistics().getDescription());
        orderDto.setProduct(order.getProduct().getDescription());
        return orderDto;
    }
}
