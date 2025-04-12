package com.tch.drinkods.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tch.drinkods.entity.Orderer;

@Repository
public interface OrdererRepository extends JpaRepository<Orderer, Long> {
    // 根據訂購人名稱查找
    List<Orderer> findByName(String name);
}