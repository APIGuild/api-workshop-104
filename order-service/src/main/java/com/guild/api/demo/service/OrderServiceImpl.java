package com.guild.api.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.guild.api.demo.dao.CustomerDao;
import com.guild.api.demo.dao.LogisticsDao;
import com.guild.api.demo.model.CustomerModel;
import com.guild.api.demo.model.LogisticsModel;
import com.guild.api.demo.model.OrderModel;
import com.guild.api.demo.repository.OrderRepository;
import com.guild.api.demo.repository.entity.OrderEntity;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LogisticsDao logisticsDao;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderModel getOrder(String orderId) {
        OrderEntity orderEntity = orderRepository.getOrder(orderId);

        if (orderEntity == null) {
            throw new RuntimeException("Order Not Found");
        }

        OrderModel orderModel = new OrderModel();

        orderModel.setOrderId(orderEntity.getOrderId());
        orderModel.setOrderTitle(orderEntity.getOrderTitle());
        orderModel.setOrderTime(orderEntity.getOrderTime());
        orderModel.setDescription(orderEntity.getDescription());

        String customerId = orderEntity.getCustomerId();
        String logisticsId = orderEntity.getLogisticsId();

        String customer = customerDao.getCustomer(customerId);

        String logistics = logisticsDao.getLogistics(logisticsId);

        orderModel.setCustomer(new CustomerModel(customerId, customer));
        orderModel.setLogistics(new LogisticsModel(logisticsId, logistics));

        return orderModel;
    }
}
