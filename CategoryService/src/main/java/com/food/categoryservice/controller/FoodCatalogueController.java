package com.food.categoryservice.controller;


import com.food.categoryservice.dto.FoodCatalogPage;
import com.food.categoryservice.dto.FoodItemDTO;
import com.food.categoryservice.service.FoodCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/food-delivery-app/catalogs")
public class FoodCatalogueController {

    @Autowired
    private FoodCatalogService catalogService;


    @PostMapping
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO foodItemDTOSaved = catalogService.addFoodItemDb(foodItemDTO);
        return new ResponseEntity<>(foodItemDTOSaved, HttpStatus.CREATED);
    }

    @GetMapping("/food-items-restaurant/{restaurantId}")
    public ResponseEntity<FoodCatalogPage> getRestaurantDetailByRestaurantId(@PathVariable int restaurantId){
        FoodCatalogPage foodCatalogPage = catalogService.getRestaurantDetailByRestaurantId(restaurantId);
        return new ResponseEntity<>(foodCatalogPage, HttpStatus.OK);
    }


}
