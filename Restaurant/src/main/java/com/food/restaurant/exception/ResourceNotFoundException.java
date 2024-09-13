package com.food.restaurant.exception;

//Custom Exception class
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
