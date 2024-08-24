package com.food.orderservice.controller;

import com.food.orderservice.dto.OrderDTO;
import com.food.orderservice.dto.OrderDTOFromFE;
import com.food.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/food-delivery-app/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDTOFromFE){
        OrderDTO orderDTO = orderService.saverOrderInDb(orderDTOFromFE);
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }


}
