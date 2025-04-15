package com.tch.drinkods.controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tch.drinkods.Controller.DrinkController;
import com.tch.drinkods.Entity.Drink;
import com.tch.drinkods.Service.DrinkService;







class DrinkControllerTest {

    @Mock
    private DrinkService drinkService;

    @InjectMocks
    private DrinkController drinkController;

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
            new Drink("Mocha", "Extra Chocolate")
        );
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

    // 測試刪除飲料
    @Test
    void testDeleteDrink() {
        Long drinkId = 1L;

        ResponseEntity<Void> response = drinkController.deleteDrink(drinkId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        verify(drinkService, times(1)).deleteDrink(drinkId);
    }
}