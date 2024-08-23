package com.food.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private List<FoodItemDTO> foodItems;
    private int userId;
    private Restaurant restaurant;
}
