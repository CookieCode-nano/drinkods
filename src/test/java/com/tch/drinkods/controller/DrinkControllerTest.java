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

    // 測試新增飲料
    @Test
    void testCreateDrink() {
        Drink drink = new Drink("Latte", "No Sugar");
        when(drinkService.createDrink(drink)).thenReturn(drink);

        ResponseEntity<Drink> response = drinkController.createDrink(drink);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(drink);
        verify(drinkService, times(1)).createDrink(drink);
    }

    // 測試查詢所有飲料
    @Test
    void testGetAllDrinks() {
        List<Drink> drinks = Arrays.asList(
                new Drink("Latte", "No Sugar"),
                new Drink("Mocha", "Extra Chocolate"));
        when(drinkService.getAllDrinks()).thenReturn(drinks);

        List<Drink> result = drinkController.getAllDrinks();

        assertThat(result).isEqualTo(drinks);
        verify(drinkService, times(1)).getAllDrinks();
    }

    // 測試根據ID查找飲料
    @Test
    void testGetDrinkById() {
        Long drinkId = 1L;
        Drink drink = new Drink("Latte", "No Sugar");
        when(drinkService.getDrinkById(drinkId)).thenReturn(drink);

        ResponseEntity<Drink> response = drinkController.getDrinkById(drinkId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(drink);
        verify(drinkService, times(1)).getDrinkById(drinkId);
    }

    // 測試更新飲料
    @Test
    void testUpdateDrink() {
        Long drinkId = 1L;
        Drink updatedDrink = new Drink("Latte", "Less Sugar");
        when(drinkService.updateDrink(drinkId, updatedDrink)).thenReturn(updatedDrink);

        ResponseEntity<Drink> response = drinkController.updateDrink(drinkId, updatedDrink);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(updatedDrink);
        verify(drinkService, times(1)).updateDrink(drinkId, updatedDrink);
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
