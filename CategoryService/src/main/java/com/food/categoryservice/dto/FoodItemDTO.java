package com.food.categoryservice.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDTO {
    private int id;
    private String name;
    private String description;
    private boolean isVegetarian;
    private double price;
    private int restaurantId;
    private int quantity;
}