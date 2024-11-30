package com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.response;

import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.exceptions.ResourceNotFound;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    @JsonFormat(pattern = "hh:mm:ss dd-MM-yyyy")
    private LocalDateTime timeStamp;

    private T data;

    private ResourceNotFound error;

   public ApiResponse(){
       this.timeStamp = LocalDateTime.now();
   }

   public ApiResponse(T data){
       this();
       this.data = data;
   }

   public ApiResponse(ResourceNotFound error) {
       this();
       this.error = error;
   }

}
