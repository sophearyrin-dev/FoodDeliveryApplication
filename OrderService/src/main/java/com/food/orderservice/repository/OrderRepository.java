package com.food.orderservice.repository;

import com.food.orderservice.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, Integer> {
}
