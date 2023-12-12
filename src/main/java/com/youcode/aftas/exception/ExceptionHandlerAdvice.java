package com.youcode.aftas.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(LogicValidationException.class)
    public ResponseEntity<Object> handleCustomValidationException(LogicValidationException ex) {
        return ResponseEntity.badRequest()
                .body(ex.getMessage());
    }
}
