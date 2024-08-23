package com.food.orderservice.dto;

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
