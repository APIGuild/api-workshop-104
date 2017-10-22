package com.guild.api.demo.controller.translator;

import org.springframework.stereotype.Component;
import com.guild.api.demo.controller.dto.OrderDto;
import com.guild.api.demo.controller.dto.ResourceDto;
import com.guild.api.demo.controller.dto.ResponseWrapper;
import com.guild.api.demo.model.OrderModel;

@Component
public class OrderTranslator {
    public ResponseWrapper<OrderDto> translate(OrderModel order) {
        OrderDto orderDto = new OrderDto(order.getOrderTitle(), order.getOrderTime(),
                order.getCustomer().getDescription(), order.getLogistics().getDescription());
        ResponseWrapper<OrderDto> response = new ResponseWrapper<>();
        ResourceDto<OrderDto> resourceData = new ResourceDto<>();
        resourceData.setAttributes(orderDto);
        resourceData.setId(order.getOrderId());
        response.setData(resourceData);
        return response;
    }
}
