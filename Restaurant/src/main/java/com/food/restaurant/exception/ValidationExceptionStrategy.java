//package com.food.restaurant.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.sql.Timestamp;
//
//public class ValidationExceptionStrategy implements ExceptionStrategy {
//
//    @Override
//    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
//        ValidationException ex = (ValidationException) exception;
//        return new ResponseEntity<>(new ErrorResponse(
//                HttpStatus.BAD_REQUEST.value(),
//                ex.getMessage(),
//                new Timestamp(System.currentTimeMillis())
//        ), HttpStatus.BAD_REQUEST);
//    }
//}
//
