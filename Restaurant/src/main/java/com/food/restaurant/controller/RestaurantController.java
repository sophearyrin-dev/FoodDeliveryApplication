package com.food.restaurant.controller;

import com.food.restaurant.dto.RestaurantDTO;
import com.food.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food-delivery-app/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/get-all-restaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurant(){
        List<RestaurantDTO> restaurantDTOS = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(restaurantDTOS, HttpStatus.OK);
    }

    @PostMapping("/add-restaurant")
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        RestaurantDTO restaurantDtoAdded = restaurantService.addRestaurantInDB(restaurantDTO);
        return new ResponseEntity<>(restaurantDtoAdded, HttpStatus.CREATED);
    }
}
