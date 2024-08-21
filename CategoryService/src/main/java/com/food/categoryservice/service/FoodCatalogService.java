package com.food.categoryservice.service;

import com.food.categoryservice.dto.FoodItemDTO;
import com.food.categoryservice.entity.FoodItem;
import com.food.categoryservice.mapper.FoodItemMapper;
import com.food.categoryservice.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodCatalogService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    public FoodItemDTO addFoodItemDb(FoodItemDTO foodItemDTO) {
        FoodItem foodItemSaved = foodItemRepository.save(FoodItemMapper.INSTANCE.mapFromFoodItemDTOTOFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFromFoodItemToFoodItemDTO(foodItemSaved);
    }
}
