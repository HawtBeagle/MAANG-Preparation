package com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.homework.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DepartmentDTO {

    private Long id;

    @NotBlank
    private String title;

    @NotNull
    private Boolean isActive;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate createdAt;
}
