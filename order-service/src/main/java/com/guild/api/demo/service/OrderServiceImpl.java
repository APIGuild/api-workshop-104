package com.guild.api.demo.service;

import static com.guild.api.demo.util.rxjava.AsyncTemplate.async;
import static java.lang.String.format;
import static java.util.Optional.ofNullable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.guild.api.demo.dao.LogisticsDao;
import com.guild.api.demo.dao.ProductDao;
import com.guild.api.demo.dao.UserDao;
import com.guild.api.demo.exception.ResourceNotFound;
import com.guild.api.demo.model.LogisticsModel;
import com.guild.api.demo.model.OrderModel;
import com.guild.api.demo.model.ProductModel;
import com.guild.api.demo.model.UserModel;
import com.guild.api.demo.repository.OrderRepository;
import com.guild.api.demo.repository.entity.OrderEntity;
import com.guild.api.demo.service.assembler.ProductAssembler;
import com.guild.api.demo.service.assembler.UserAssembler;
import com.guild.api.demo.service.mapper.OrderModelMapper;
import com.guild.api.demo.util.rxjava.AsyncResult;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;


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

    private OrderModelMapper orderMapper = new OrderModelMapper();

    @Override
    public OrderModel getOrder(String orderId) {
        OrderEntity orderEntity = ofNullable(orderRepository.getOrder(orderId))
                .orElseThrow(() -> new ResourceNotFound(format("Order ID <%s> Not Found!", orderId)));
        OrderModel orderModel = orderMapper.map(orderEntity, OrderModel.class);

        Single<AsyncResult<UserModel>> userAsyncResult = async(() -> userDao.getUser(orderEntity.getUserId()));
        Single<AsyncResult<LogisticsModel>> logisticsAsyncResult = async(() -> logisticsDao.getLogistics(orderEntity.getLogisticsId()));
        Single<AsyncResult<ProductModel>> productAsyncResult = async(() -> productDao.getProduct(orderEntity.getProductId()));

        Single<OrderModel> resultStream = Single.just(orderModel)
                .zipWith(userAsyncResult, new UserAssembler())
                .zipWith(logisticsAsyncResult, this::assembleLogistics)
                .zipWith(productAsyncResult, new ProductAssembler())
                .subscribeOn(Schedulers.io());

        return resultStream.blockingGet();
    }

    private OrderModel assembleLogistics(OrderModel orderModel, AsyncResult<LogisticsModel> asyncResult) throws Exception {
        if (asyncResult.hasException()) {
            throw new RuntimeException("Logistics Error!");
        }
        orderModel.setLogistics(asyncResult.getValue());
        return orderModel;
    }

}
