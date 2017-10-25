package com.guild.api.demo.service;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.guild.api.demo.dao.LogisticsDao;
import com.guild.api.demo.dao.ProductDao;
import com.guild.api.demo.dao.UserDao;
import com.guild.api.demo.exception.ResourceNotFound;
import com.guild.api.demo.model.UserModel;
import com.guild.api.demo.model.LogisticsModel;
import com.guild.api.demo.model.OrderModel;
import com.guild.api.demo.model.ProductModel;
import com.guild.api.demo.repository.OrderRepository;
import com.guild.api.demo.repository.entity.OrderEntity;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LogisticsDao logisticsDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderModel getOrder(String orderId) {
        OrderEntity orderEntity = ofNullable(orderRepository.getOrder(orderId))
                .orElseThrow(() -> new ResourceNotFound(format("Order ID <%s> Not Found!", orderId)));

        OrderModel orderModel = new OrderModel();


        // Map and auto generate setter getter
        orderModel.setOrderId(orderEntity.getOrderId());
        orderModel.setOrderTitle(orderEntity.getOrderTitle());
        orderModel.setOrderTime(orderEntity.getOrderTime());
        orderModel.setDescription(orderEntity.getDescription());

        String userId = orderEntity.getUserId();
        String logisticsId = orderEntity.getLogisticsId();
        String productId = orderEntity.getProductId();

        String userInfo = userDao.getUser(userId);

        String logisticsInfo = logisticsDao.getLogistics(logisticsId);

        String productInfo = productDao.getProduct(productId);

        orderModel.setUser(new UserModel(userId, userInfo));
        orderModel.setLogistics(new LogisticsModel(logisticsId, logisticsInfo));
        orderModel.setProduct(new ProductModel(productId, productInfo));

        return orderModel;
    }
}
