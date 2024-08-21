package com.food.categoryservice.repository;

import com.food.categoryservice.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem,Integer> {
}
