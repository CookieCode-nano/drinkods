package com.tch.drinkods.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tch.drinkods.Entity.Drink;
import com.tch.drinkods.Repository.DrinkRepository;

@Service
public class DrinkService {
    @Autowired
    private DrinkRepository drinkRepository;

    // 新增飲料
    public Drink createDrink(Drink drink) {
        return drinkRepository.save(drink);
    }

    // 查詢所有飲料
    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    // 根據ID查找飲料
    public Drink getDrinkById(Long id) {
        return drinkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Drink not found"));
    }

    // 更新飲料
    public Drink updateDrink(Long id, Drink updatedDrink) {
        Drink drink = getDrinkById(id);
        drink.setName(updatedDrink.getName());
        drink.setDefaultCustomizations(updatedDrink.getDefaultCustomizations());
        return drinkRepository.save(drink);
    }

    // 刪除飲料
    public void deleteDrink(Long id) {
        drinkRepository.deleteById(id);
    }
}