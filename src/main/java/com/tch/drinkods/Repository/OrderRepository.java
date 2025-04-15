package com.tch.drinkods.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tch.drinkods.Entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    // 根據訂購人 ID 查找歷史訂單
    List<Orders> findByOrdererId(Long ordererId);

    // 根據飲料 ID 查找歷史訂單
    List<Orders> findByDrinkId(Long drinkId);

    // 根據自訂內容篩選訂單
    List<Orders> findByCustomizationsContaining(String keyword);
}