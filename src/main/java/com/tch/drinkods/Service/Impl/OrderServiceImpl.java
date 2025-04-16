package com.tch.drinkods.Service.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tch.drinkods.DTO.OrderRequest;
import com.tch.drinkods.DTO.OrderResponse;
import com.tch.drinkods.Entity.Drink;
import com.tch.drinkods.Entity.Orderer;
import com.tch.drinkods.Entity.Orders;
import com.tch.drinkods.Repository.DrinkRepository;
import com.tch.drinkods.Repository.OrderRepository;
import com.tch.drinkods.Repository.OrdererRepository;
import com.tch.drinkods.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private OrdererRepository ordererRepository;

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        // 查找飲料
        Drink drink = drinkRepository.findByName(orderRequest.getDrinkName())
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("飲料不存在"));

        // 查找或新增訂購人
        Orderer orderer = ordererRepository.findByName(orderRequest.getOrdererName())
                .stream()
                .findFirst()
                .orElseGet(() -> {
                    Orderer newOrderer = new Orderer(orderRequest.getOrdererName(), null);
                    return ordererRepository.save(newOrderer);
                });

        // 建立訂單
        Orders order = new Orders(drink, orderer, orderRequest.getCustomizations(), LocalDateTime.now());
        Orders savedOrder = orderRepository.save(order);

        // 回傳 OrderResponse
        return new OrderResponse(
                savedOrder.getDrink().getName(),
                savedOrder.getOrderer().getName(),
                savedOrder.getCustomizations(),
                savedOrder.getTimestamp()
        );
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        List<Orders> orders = orderRepository.findAll();
        return orders.stream().map(order -> new OrderResponse(
                order.getDrink().getName(),
                order.getOrderer().getName(),
                order.getCustomizations(),
                order.getTimestamp()
        )).toList();
    }
}