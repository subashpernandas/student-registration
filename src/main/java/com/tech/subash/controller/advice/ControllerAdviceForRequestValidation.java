package com.tech.subash.controller.advice;

import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdviceForRequestValidation {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,Object> handleMethodArgumentNotValid(MethodArgumentNotValidException me) {
        Map<String,Object> errorMap = new HashMap<>();
        me.getBindingResult().getFieldErrors().forEach(
                e ->errorMap.put(e.getField(), e.getDefaultMessage()));
        return  errorMap;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String,Object> handleConstraintViolationNotValid(ConstraintViolationException me) {
        Map<String,Object> errorMap = new HashMap<>();
        me.getConstraintViolations().forEach(
                e -> errorMap.put(e.getPropertyPath().toString(), e.getMessage()));
        return  errorMap;
    }
}
