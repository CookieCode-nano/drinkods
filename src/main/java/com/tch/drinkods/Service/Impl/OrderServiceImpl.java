package com.tch.drinkods.Service.Impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tch.drinkods.DTO.OrderRequest;
import com.tch.drinkods.DTO.OrderResponse;
import com.tch.drinkods.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    private final List<OrderResponse> orders = new ArrayList<>();

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setDrinkName(orderRequest.getDrinkName());
        orderResponse.setOrdererName(orderRequest.getOrdererName());
        orderResponse.setCustomizations(orderRequest.getCustomizations());
        orderResponse.setTimestamp(LocalDateTime.now());

        orders.add(orderResponse);
        return orderResponse;
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return orders;
    }
}