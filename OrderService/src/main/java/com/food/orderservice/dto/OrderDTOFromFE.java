package com.food.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTOFromFE {
    private int orderId;
    private List<FoodItemDTO> foodItems;
    private Restaurant restaurant;
    private UserDTO userDTO;
}
