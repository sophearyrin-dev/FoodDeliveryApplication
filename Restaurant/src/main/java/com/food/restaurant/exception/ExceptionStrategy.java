package com.food.restaurant.exception;

import org.springframework.http.ResponseEntity;

public interface ExceptionStrategy {
    ResponseEntity<ErrorResponse> handleException(Exception exception);
}

