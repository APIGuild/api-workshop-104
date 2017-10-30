package com.guild.api.demo.service;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.guild.api.demo.dao.LogisticsDao;
import com.guild.api.demo.dao.ProductDao;
import com.guild.api.demo.dao.UserDao;
import com.guild.api.demo.exception.ResourceNotFoundException;
import com.guild.api.demo.model.LogisticsModel;
import com.guild.api.demo.model.OrderModel;
import com.guild.api.demo.model.ProductModel;
import com.guild.api.demo.model.UserModel;
import com.guild.api.demo.repository.OrderRepository;
import com.guild.api.demo.repository.entity.OrderEntity;
import com.guild.api.demo.service.mapper.OrderModelMapper;


@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LogisticsDao logisticsDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderRepository orderRepository;

    private OrderModelMapper orderModelMapper = new OrderModelMapper();

    @Override
    public OrderModel getOrder(String orderId) {
        OrderEntity orderEntity = ofNullable(orderRepository.getOrder(orderId))
                .orElseThrow(() -> new ResourceNotFoundException(format("Order ID <%s> Not Found!", orderId)));

        OrderModel orderModel = orderModelMapper.map(orderEntity, OrderModel.class);

        UserModel user = userDao.getUser(orderEntity.getUserId());
        LogisticsModel logistics = logisticsDao.getLogistics(orderEntity.getLogisticsId());
        ProductModel product = productDao.getProduct(orderEntity.getProductId());

        orderModel.setUser(user);
        orderModel.setLogistics(logistics);
        orderModel.setProduct(product);

        return orderModel;
    }

}
