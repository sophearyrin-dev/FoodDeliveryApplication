package com.food.restaurant.service;

import com.food.restaurant.dto.RestaurantDTO;
import com.food.restaurant.entity.Restaurant;
import com.food.restaurant.mapper.RestaurantMapper;
import com.food.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;


    public List<RestaurantDTO> findAllRestaurants() {

        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<RestaurantDTO> restaurantDTOS =
                restaurants.stream()
                        .map(
                                restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant))
                        .collect(Collectors.toList());

        return restaurantDTOS;

    }

    public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantRepository
                .save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));

        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant);
    }

    public ResponseEntity<RestaurantDTO> getRestaurantById(int restaurantId) {
       Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
       if(restaurant.isPresent()){
           return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()), HttpStatus.FOUND);
       }
       return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
