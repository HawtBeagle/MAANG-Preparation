package com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.controllers;

import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.dtos.EmployeeDTO;
import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.repositories.EmployeeRepo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @GetMapping(path = "/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable Long id) {
        return employeeRepo.findById(id).orElse(null);
    }


    @PostMapping("/new")
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity emp) {
        return employeeRepo.save(emp);
    }
}
