package com.mongodb.starter.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionControllerAdvice {
    @ExceptionHandler(value= CustomExceptions.class)
    public final ResponseEntity<String> handleCostumerException(CustomExceptions Exception) {
        return new ResponseEntity<>(Exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = AuthenticationFailException.class)
    public final ResponseEntity<String> handleAuthenticationFailException(AuthenticationFailException Exception){
        return new ResponseEntity<>(Exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
