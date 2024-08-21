package com.food.categoryservice.mapper;

import com.food.categoryservice.dto.FoodItemDTO;
import com.food.categoryservice.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItem mapFromFoodItemDTOTOFoodItem(FoodItemDTO foodItemDTO);
    FoodItemDTO mapFromFoodItemToFoodItemDTO(FoodItem foodItem);

}
