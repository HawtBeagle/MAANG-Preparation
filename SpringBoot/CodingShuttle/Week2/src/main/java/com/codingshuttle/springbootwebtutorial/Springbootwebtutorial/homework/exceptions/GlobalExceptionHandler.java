package com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.homework.exceptions;

import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.homework.dtos.responses.DepartmentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<DepartmentResponse<?>> sendError(NoSuchElementException exception) {
        DepartmentResponse<?> departmentResponse = DepartmentResponse
                .builder()
                .status(HttpStatus.NOT_FOUND)
                .error(exception.getMessage())
                .build();
        return new ResponseEntity<>(departmentResponse, HttpStatus.NOT_FOUND);
    }
}
