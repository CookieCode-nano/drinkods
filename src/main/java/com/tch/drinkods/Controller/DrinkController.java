package com.tch.drinkods.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tch.drinkods.Service.DrinkService;
import com.tch.drinkods.entity.Drink;

@RestController
@RequestMapping("/drinks")
public class DrinkController {
    @Autowired
    private DrinkService drinkService;

    // 新增飲料
    @PostMapping
    public ResponseEntity<Drink> createDrink(@RequestBody Drink drink) {
        return new ResponseEntity<>(drinkService.createDrink(drink), HttpStatus.CREATED);
    }

    // 查詢所有飲料
    @GetMapping
    public List<Drink> getAllDrinks() {
        return drinkService.getAllDrinks();
    }

    // 根據ID查找飲料
    @GetMapping("/{id}")
    public ResponseEntity<Drink> getDrinkById(@PathVariable Long id) {
        return new ResponseEntity<>(drinkService.getDrinkById(id), HttpStatus.OK);
    }

    // 更新飲料
    @PutMapping("/{id}")
    public ResponseEntity<Drink> updateDrink(@PathVariable Long id, @RequestBody Drink drink) {
        return new ResponseEntity<>(drinkService.updateDrink(id, drink), HttpStatus.OK);
    }

    // 刪除飲料
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrink(@PathVariable Long id) {
        drinkService.deleteDrink(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}