package com.food.categoryservice.repository;

import com.food.categoryservice.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem,Integer> {
    List<FoodItem> findByRestaurantId(int restaurantId);
}
