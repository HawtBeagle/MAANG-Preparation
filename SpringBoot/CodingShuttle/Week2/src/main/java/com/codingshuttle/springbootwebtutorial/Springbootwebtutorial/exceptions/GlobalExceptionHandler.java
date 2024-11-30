package com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.exceptions;

import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiResponse<?>> resolveNoSuchElementException(NoSuchElementException exception) {
        ResourceNotFound resourceNotFound = ResourceNotFound
                .builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();
        return buildErrorResponse(resourceNotFound);
    }

    private ResponseEntity<ApiResponse<?>> buildErrorResponse(ResourceNotFound resourceNotFound) {
        return new ResponseEntity<>(new ApiResponse<>(resourceNotFound), resourceNotFound.getStatus());
    }
}
