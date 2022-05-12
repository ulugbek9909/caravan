package com.caravan.caravan.controller;

import com.caravan.caravan.exceptions.ItemAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({ItemAlreadyExistsException.class})
    public ResponseEntity<?> handleForbidden(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
