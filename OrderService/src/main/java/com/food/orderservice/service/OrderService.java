package com.food.orderservice.service;

import com.food.orderservice.dto.OrderDTO;
import com.food.orderservice.dto.OrderDTOFromFE;
import com.food.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderDTO saverOrderInDb(OrderDTOFromFE orderDTOFromFE) {

    }
}
