package com.food.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class ExceptionStrategyContext {
    private final Map<Class<? extends Exception>, ExceptionStrategy> strategies = new HashMap<>();

    public ExceptionStrategyContext() {
        strategies.put(ResourceNotFoundException.class, new ResourceNotFoundStrategy());
        //strategies.put(ValidationException.class, new ValidationExceptionStrategy());
        strategies.put(MethodArgumentNotValidException.class, new MethodArgumentNotValidExceptionStrategy()); // Add this line
    }

    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ExceptionStrategy strategy = strategies.get(exception.getClass());
        if (strategy != null) {
            return strategy.handleException(exception);
        }
        return new ResponseEntity<>(new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal server error",
                new Timestamp(System.currentTimeMillis())
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


