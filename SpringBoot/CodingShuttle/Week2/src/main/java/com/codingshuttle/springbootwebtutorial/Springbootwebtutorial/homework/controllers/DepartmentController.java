package com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.homework.controllers;

import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.homework.dtos.DepartmentDTO;
import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.homework.services.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return ResponseEntity.ok(departmentService.createDepartment(departmentDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@PathVariable Long id, @RequestBody DepartmentDTO departmentDTO) {
        return ResponseEntity.ok(departmentService.updateDepartmentById(id, departmentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean>deleteDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.deleteDepartmentById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartmentPartiallyById(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(departmentService.updateDepartmentPartiallyById(id, updates));
    }

}
