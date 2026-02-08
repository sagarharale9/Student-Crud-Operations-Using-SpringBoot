package com.spring.myapp.ExceptionHandler;

import com.spring.myapp.dto.ErrorApiResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> illegalArgExchandler (IllegalArgumentException ex){
        String errorMessage= ex.getMessage();
        String statusCode= HttpStatus.BAD_REQUEST.toString();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorApiResponce(HttpStatus.NOT_FOUND.value(),errorMessage));
    }
}
