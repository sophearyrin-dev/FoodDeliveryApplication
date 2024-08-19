package com.food.restaurant.controller;

import com.food.restaurant.dto.RestaurantDTO;
import com.food.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/getAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurant(){
        List<RestaurantDTO> restaurantDTOS = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(restaurantDTOS, HttpStatus.OK);
    }
}
