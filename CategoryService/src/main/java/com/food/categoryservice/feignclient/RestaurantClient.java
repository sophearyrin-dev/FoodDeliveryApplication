package com.food.categoryservice.feignclient;

import com.food.categoryservice.dto.RestaurantDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "RESTAURANT-SERVICE")
public interface RestaurantClient {
    @GetMapping(value = "/api/v1/food-delivery-app/restaurants/{restaurantId}")
    RestaurantDTO getRestaurantById(@PathVariable("restaurantId") int restaurantId);
}




