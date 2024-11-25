package com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.controllers;

import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.dtos.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {


    @GetMapping
    public String getAllEmployees(@RequestParam(required = false) Long id) {
        return String.valueOf(id);
    }

    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return new EmployeeDTO(id, "bhanu", "bhanuprakash@gmail.com", LocalDate.of(2024, 11, 25), true);
    }
}
