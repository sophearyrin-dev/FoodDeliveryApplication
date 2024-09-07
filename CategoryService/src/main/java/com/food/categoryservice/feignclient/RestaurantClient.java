package com.food.categoryservice.feignclient;

import com.food.categoryservice.dto.RestaurantDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//http://RESTAURANT-SERVICE/api/v1/food-delivery-app/restaurants/
//@FeignClient(name = "RESTAURANT-SERVICE", url = "http://RESTAURANT-SERVICE/", path = "api/v1/food-delivery-app/restaurants/")
//public interface RestaurantClient {
//    @GetMapping("/{id}")
//    ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable("id") int id);
//}

@FeignClient(name = "restaurant-service", url = "http://RESTAURANT-SERVICE/api/v1/food-delivery-app/restaurants")
public interface RestaurantClient {
    @GetMapping("/{restaurantId}")
    RestaurantDTO getRestaurantById(@PathVariable("restaurantId") int restaurantId);
}




