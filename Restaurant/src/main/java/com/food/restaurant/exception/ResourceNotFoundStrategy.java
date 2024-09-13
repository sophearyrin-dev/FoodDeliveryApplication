package com.food.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;

public class ResourceNotFoundStrategy implements ExceptionStrategy {

    @Override
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ResourceNotFoundException ex = (ResourceNotFoundException) exception;
        return new ResponseEntity<>(new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                new Timestamp(System.currentTimeMillis())
        ), HttpStatus.NOT_FOUND);
    }
}

