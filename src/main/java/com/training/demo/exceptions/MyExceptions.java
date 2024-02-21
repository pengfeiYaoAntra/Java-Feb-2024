package com.training.demo.exceptions;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.slf4j.Logger;

@ControllerAdvice
public class MyExceptions {
    private static final Logger logger =  LoggerFactory.getLogger(MyExceptions.class);
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e){
        logger.warn("An IllegalArgumentException exception occurred: " + e.getMessage() + ". we logged in logger file");

        return ResponseEntity.badRequest().body("An IllegalArgumentException exception occurred:" + e.getMessage());
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(ArithmeticException e){
        logger.warn("An arithmetic exception occurred: " + e.getMessage() + ". we logged in logger file");

        return ResponseEntity.badRequest().body("An arithmetic exception occurred:" + e.getMessage());
    }
}
