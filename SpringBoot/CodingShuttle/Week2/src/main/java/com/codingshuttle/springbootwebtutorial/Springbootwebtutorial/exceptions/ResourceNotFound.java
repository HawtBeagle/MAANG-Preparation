package com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.exceptions;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ResourceNotFound {
    private HttpStatus status;
    private String message;
}
