package com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.dtos;

import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank
    private String name;

    @Email
    private String email;

    @Past
    private LocalDate dateOfJoining;

    @AssertTrue
    private Boolean isActive;

    @EmployeeRoleValidation
    private String role;

}
