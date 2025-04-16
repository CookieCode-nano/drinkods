package com.tch.drinkods.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tch.drinkods.Controller.DrinkController;
import com.tch.drinkods.DTO.OrderRequest;
import com.tch.drinkods.DTO.OrderResponse;
import com.tch.drinkods.Entity.Drink;
import com.tch.drinkods.Service.DrinkService;
import com.tch.drinkods.Service.Impl.OrderServiceImpl;

class DrinkControllerTest {

    @Mock
    private DrinkService drinkService;
    @Mock

    private OrderServiceImpl Orderimpl;
    

    @InjectMocks
    private DrinkController drinkController;

    @Mock
    private DrinkService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateOrder() {
        OrderRequest orderRequest = new OrderRequest("Latte", "John Doe", "No Sugar");
        OrderResponse orderResponse = new OrderResponse("Latte", "John Doe", "No Sugar", LocalDateTime.now());
        when(Orderimpl.createOrder(orderRequest)).thenReturn(orderResponse);

        ResponseEntity<OrderResponse> response = drinkController.createOrder(orderRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(orderResponse);
        verify(Orderimpl, times(1)).createOrder(orderRequest);
    }

}
