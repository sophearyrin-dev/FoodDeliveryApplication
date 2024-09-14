package com.food.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.sql.Timestamp;

public class MethodArgumentNotValidExceptionStrategy implements ExceptionStrategy {

    @Override
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        MethodArgumentNotValidException ex = (MethodArgumentNotValidException) exception;

        // Extract validation errors
        StringBuilder validationErrors = new StringBuilder();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            validationErrors.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("; ");
        });

        return new ResponseEntity<>(new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                validationErrors.toString(),
                new Timestamp(System.currentTimeMillis())
        ), HttpStatus.BAD_REQUEST);
    }
}

