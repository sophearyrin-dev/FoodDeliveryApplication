package com.food.restaurant.service;

import com.food.restaurant.dto.RestaurantDTO;
import com.food.restaurant.entity.Restaurant;
import com.food.restaurant.exception.ResourceNotFoundException;
import com.food.restaurant.exception.ValidationException;
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

    public List<RestaurantDTO> findAllRestaurants() {
        return restaurantRepository.findAll()
                .stream()
                .map(restaurantMapper::mapRestaurantToRestaurantDTO)
                .collect(Collectors.toList());
    }

    public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO) {
        if (restaurantDTO.getName() == null || restaurantDTO.getName().isEmpty()) {
            throw new ValidationException(ErrorMessages.ERROR_RESTAURANT_MUST_NOT_EMPTY);
        }
        Restaurant restaurant = restaurantMapper.mapRestaurantDTOToRestaurant(restaurantDTO);
        restaurant = restaurantRepository.save(restaurant);
        return restaurantMapper.mapRestaurantToRestaurantDTO(restaurant);
    }

    public ResponseEntity<RestaurantDTO> getRestaurantById(int restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.ERROR_RESTAURANT_NOT_FOUND+ restaurantId));

        RestaurantDTO restaurantDTO = restaurantMapper.mapRestaurantToRestaurantDTO(restaurant);
        return new ResponseEntity<>(restaurantDTO, HttpStatus.OK);
    }
}
