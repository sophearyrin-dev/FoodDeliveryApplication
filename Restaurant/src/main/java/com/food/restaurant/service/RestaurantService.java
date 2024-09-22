package com.food.restaurant.service;

import com.food.restaurant.dto.request.RestaurantRequest;
import com.food.restaurant.dto.response.RestaurantResponse;
import com.food.restaurant.entity.Restaurant;
import com.food.restaurant.exception.ResourceNotFoundException;
import com.food.restaurant.mapper.RestaurantMapper;
import com.food.restaurant.repository.RestaurantRepository;
import com.food.restaurant.utility.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = RestaurantMapper.INSTANCE;
    }

    public List<RestaurantResponse> findAllRestaurants() {
        return restaurantRepository.findAll()
                .stream()
                .map(restaurantMapper::mapRestaurantToRestaurantResponse)
                .collect(Collectors.toList());
    }

    public RestaurantResponse createRestaurant(RestaurantRequest restaurantRequest) {
        Restaurant restaurant = restaurantMapper.mapRestaurantRequestToRestaurant(restaurantRequest);
        restaurant = restaurantRepository.save(restaurant);
        return restaurantMapper.mapRestaurantToRestaurantResponse(restaurant);
    }

    public ResponseEntity<RestaurantResponse> getRestaurantById(int restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.ERROR_RESTAURANT_NOT_FOUND+ restaurantId));

        RestaurantResponse restaurantResponse = restaurantMapper.mapRestaurantToRestaurantResponse(restaurant);
        return new ResponseEntity<>(restaurantResponse, HttpStatus.OK);
    }
}
