package com.food.categoryservice.service;

import com.food.categoryservice.dto.FoodCatalogPage;
import com.food.categoryservice.dto.FoodItemDTO;
import com.food.categoryservice.dto.Restaurant;
import com.food.categoryservice.entity.FoodItem;
import com.food.categoryservice.mapper.FoodItemMapper;
import com.food.categoryservice.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
public class FoodCatalogService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    RestTemplate restTemplate;


    public FoodItemDTO addFoodItemDb(FoodItemDTO foodItemDTO) {
        FoodItem foodItemSaved = foodItemRepository.save(FoodItemMapper.INSTANCE.mapFromFoodItemDTOTOFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFromFoodItemToFoodItemDTO(foodItemSaved);
    }

    public FoodCatalogPage getRestaurantDetailByRestaurantId(int restaurantId) {
        List<FoodItem> foodItems = getAllFoodItemsByRestaurantId(restaurantId);
        Restaurant restaurant = getRestaurantByRestaurantId(restaurantId);
        FoodCatalogPage foodCatalogPage = getFoodCatalogPage(foodItems, restaurant);
        return foodCatalogPage;
    }

    private FoodCatalogPage getFoodCatalogPage(List<FoodItem> foodItems, Restaurant restaurant) {
        FoodCatalogPage foodCatalogPage = new FoodCatalogPage();
        foodCatalogPage.setFoodItems(foodItems);
        foodCatalogPage.setRestaurant(restaurant);
        return foodCatalogPage;
    }

    private Restaurant getRestaurantByRestaurantId(int restaurantId) {
        String url = "http://RESTAURANT-SERVICE/api/v1/food-delivery-app/restaurants/";
        Restaurant restaurant = restTemplate.getForObject(url + restaurantId, Restaurant.class);
        return restaurant;
    }

    private List<FoodItem> getAllFoodItemsByRestaurantId(int restaurantId) {
        return foodItemRepository.findByRestaurantId(restaurantId);
    }
}
