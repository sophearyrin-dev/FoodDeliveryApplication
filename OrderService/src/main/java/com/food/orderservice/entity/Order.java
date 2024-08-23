package com.food.orderservice.entity;

import com.food.orderservice.dto.FoodItemDTO;
import com.food.orderservice.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    private int orderId;
    private List<FoodItemDTO> foodItems;
    private UserDTO userDTO;
}
