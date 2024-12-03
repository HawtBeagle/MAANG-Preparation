package com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.homework.dtos.responses;

import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.exceptions.ResourceNotFound;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class DepartmentResponse<T> {

    @JsonFormat(pattern = "hh-mm  dd-MM-yyyy")
    private LocalDateTime timeStamp;

    private HttpStatus status;

    private T body;

    private String error;

    public DepartmentResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public DepartmentResponse(T body) {
        this();
        this.body = body;
    }

    public DepartmentResponse(String error) {
        this();
        this.error = error;
    }

}
