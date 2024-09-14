package com.food.restaurant.controller;

import com.food.restaurant.dto.RestaurantDTO;
import com.food.restaurant.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food-delivery-app/restaurants")
@CrossOrigin
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurant(){
        List<RestaurantDTO> restaurantDTOS = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(restaurantDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RestaurantDTO> addRestaurant(@Valid @RequestBody RestaurantDTO restaurantDTO){
        RestaurantDTO restaurantDtoAdded = restaurantService.addRestaurantInDB(restaurantDTO);
        return new ResponseEntity<>(restaurantDtoAdded, HttpStatus.CREATED);
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable("restaurantId") int restaurantId) {
        return restaurantService.getRestaurantById(restaurantId);
    }

}
