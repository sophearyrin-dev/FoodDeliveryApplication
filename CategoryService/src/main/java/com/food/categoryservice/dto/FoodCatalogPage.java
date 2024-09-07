package com.food.categoryservice.dto;

import com.food.categoryservice.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCatalogPage {

    private List<FoodItemDTO> foodItems;
    private RestaurantDTO restaurant;
}
