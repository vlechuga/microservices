package com.example.customerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(NotFoundException ex) {
        final Map<String, String> error = Collections.singletonMap("error", ex.getMessage());
        return new ResponseEntity<Map<String, String>>(error, HttpStatus.NOT_FOUND);
    }
}
