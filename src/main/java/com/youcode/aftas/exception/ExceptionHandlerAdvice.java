package com.youcode.aftas.exception;

import com.youcode.aftas.web.dto.read.StandardApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(LogicValidationException.class)
    public ResponseEntity<StandardApiResponse<?>> handleCustomValidationException(LogicValidationException ex) {
        return ResponseEntity
                .badRequest()
                .body(StandardApiResponse.error(ex.getMessage()));
    }

    @ExceptionHandler(DataBaseConstraintException.class)
    public ResponseEntity<StandardApiResponse<?>> handleCustomValidationException(DataBaseConstraintException ex) {
        return ResponseEntity
                .badRequest()
                .body(StandardApiResponse.error(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardApiResponse<?>> handleCustomValidationException(MethodArgumentNotValidException ex) {
        return ResponseEntity
                .badRequest()
                .body(StandardApiResponse.validationErrors(ex.getBindingResult()));
    }
}
