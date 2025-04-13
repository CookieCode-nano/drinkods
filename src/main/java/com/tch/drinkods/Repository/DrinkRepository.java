package com.tch.drinkods.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tch.drinkods.Entity.Drink;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
    // 可以額外添加自定義查詢方法，例如根據名稱查找飲料
    List<Drink> findByName(String name);
}