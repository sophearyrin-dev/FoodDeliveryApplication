package com.food.orderservice.service;

import com.food.orderservice.dto.OrderDTO;
import com.food.orderservice.dto.OrderDTOFromFE;
import com.food.orderservice.dto.UserDTO;
import com.food.orderservice.entity.Order;
import com.food.orderservice.mapper.OrderMapper;
import com.food.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public OrderDTO saverOrderInDb(OrderDTOFromFE orderDTOFromFE) {
        Integer newOrderID = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = fetchUserDetailsFromUserId(orderDTOFromFE.getUserId());
        Order orderToBeSaved = new Order(newOrderID, orderDTOFromFE.getFoodItems(), orderDTOFromFE.getRestaurant(), userDTO );
        orderRepository.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
    }
    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://USER-SERVICE/api/v1/food-delivery-app/users/" + userId, UserDTO.class);
    }
}
