package com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.controllers;

import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.dtos.EmployeeDTO;
import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        Optional<EmployeeDTO> emp = employeeService.getEmployeeById(id);
        return emp.map(ResponseEntity::ok).orElseThrow(() -> new NoSuchElementException("Resource not found"));
    }


    @PostMapping("/new")
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO emp) {
        return new ResponseEntity<>(employeeService.createNewEmployee(emp), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@PathVariable Long id, @RequestBody EmployeeDTO emp) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(id,emp));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long id, @RequestParam(defaultValue = "false") boolean delete) {
        boolean isDeleted = employeeService.deleteEmployeeById(id, delete);
        if (isDeleted) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployeePartiallyById(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        EmployeeDTO emp = employeeService.updateEmployeePartiallyById(id, updates);
        if(emp == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(emp);
    }
}
