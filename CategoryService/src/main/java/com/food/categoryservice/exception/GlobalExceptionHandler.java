package com.food.categoryservice.exception;

import feign.FeignException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public void handleFeignStatusException(FeignException e, HttpServletResponse response) {
        response.setStatus(e.status());
    }

}
