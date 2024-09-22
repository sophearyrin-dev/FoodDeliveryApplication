package com.food.restaurant.controller;

import com.food.restaurant.dto.request.RestaurantRequest;
import com.food.restaurant.dto.response.RestaurantResponse;
import com.food.restaurant.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/food-delivery-app/restaurants")
@CrossOrigin
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    @GetMapping
    public ResponseEntity<List<RestaurantResponse>> fetchAllRestaurant(){
        List<RestaurantResponse> restaurantDTOS = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(restaurantDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RestaurantResponse> createRestaurant(@Valid @RequestBody RestaurantRequest restaurantDTO){
        RestaurantResponse newRestaurant = restaurantService.createRestaurant(restaurantDTO);
        return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<RestaurantResponse> getRestaurantById(@PathVariable("restaurantId") int restaurantId) {
        return restaurantService.getRestaurantById(restaurantId);
    }

}
