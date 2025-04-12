package com.tch.drinkods.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tch.drinkods.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // 根據訂購人 ID 查找歷史訂單
    List<Order> findByOrdererId(Long ordererId);

    // 根據飲料 ID 查找歷史訂單
    List<Order> findByDrinkId(Long drinkId);

    // 根據自訂內容篩選訂單
    List<Order> findByCustomizationsContaining(String keyword);
}