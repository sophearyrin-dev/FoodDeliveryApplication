package com.food.restaurant.mapper;

import com.food.restaurant.dto.request.RestaurantRequest;
import com.food.restaurant.dto.response.RestaurantResponse;
import com.food.restaurant.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantResponseToRestaurant(RestaurantResponse restaurantResponse);

    RestaurantResponse mapRestaurantToRestaurantResponse(Restaurant restaurant);

    Restaurant mapRestaurantRequestToRestaurant(RestaurantRequest restaurantRequest);


}
