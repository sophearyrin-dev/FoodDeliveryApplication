package com.food.categoryservice.service;

import com.food.categoryservice.dto.FoodCatalogPage;
import com.food.categoryservice.dto.FoodItemDTO;
import com.food.categoryservice.dto.RestaurantDTO;
import com.food.categoryservice.entity.FoodItem;
import com.food.categoryservice.feignclient.RestaurantClient;
import com.food.categoryservice.mapper.FoodItemMapper;
import com.food.categoryservice.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodCatalogService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private RestaurantClient restaurantClient;

    @Autowired
    RestTemplate restTemplate;


    public FoodItemDTO addFoodItemDb(FoodItemDTO foodItemDTO) {
        FoodItem foodItemSaved = foodItemRepository.save(FoodItemMapper.INSTANCE.mapFromFoodItemDTOTOFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFromFoodItemToFoodItemDTO(foodItemSaved);
    }


    private RestaurantDTO getRestaurantByRestaurantId(int restaurantId) {
//        String url = "http://RESTAURANT-SERVICE/api/v1/food-delivery-app/restaurants/";
//        RestaurantDTO restaurant = restTemplate.getForObject(url + restaurantId, RestaurantDTO.class);
//        return restaurant;
        return restaurantClient.getRestaurantById(restaurantId);
    }

    public FoodCatalogPage getRestaurantDetailByRestaurantId(int restaurantId){

        List<FoodItemDTO> foodItemDTOS = getAllFoodItemsByRestaurantId(restaurantId);
        RestaurantDTO restaurantDTO = getRestaurantByRestaurantId(restaurantId);

        FoodCatalogPage foodCatalogPage = new FoodCatalogPage();
        foodCatalogPage.setFoodItems(foodItemDTOS);
        foodCatalogPage.setRestaurant(restaurantDTO);

        return foodCatalogPage;

    }

    private List<FoodItemDTO> getAllFoodItemsByRestaurantId(int restaurantId) {
        List<FoodItemDTO> foodItemDTOS = foodItemRepository.findByRestaurantId(restaurantId).stream()
                .map(foodItem -> FoodItemMapper.INSTANCE.mapFromFoodItemToFoodItemDTO(foodItem)).collect(Collectors.toList());
        return foodItemDTOS;
    }
}
