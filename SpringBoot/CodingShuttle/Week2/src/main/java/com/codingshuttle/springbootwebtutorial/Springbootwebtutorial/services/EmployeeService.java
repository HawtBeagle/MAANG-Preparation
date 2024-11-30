package com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.services;

import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.dtos.EmployeeDTO;
import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.repositories.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepo employeeRepo, ModelMapper modelMapper) {
        this.employeeRepo = employeeRepo;
        this.modelMapper = modelMapper;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntityList = employeeRepo.findAll();
        return employeeEntityList
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .toList();
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        Optional<EmployeeEntity> employeeEntity = employeeRepo.findById(id);
        return employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1, EmployeeDTO.class));
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO emp) {
        EmployeeEntity empEnt = modelMapper.map(emp, EmployeeEntity.class);
        return modelMapper.map(employeeRepo.save(empEnt), EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(Long id, EmployeeDTO emp) {
        EmployeeEntity employee = modelMapper.map(emp, EmployeeEntity.class);
        employee.setId(id);
        return modelMapper.map(employeeRepo.save(employee), EmployeeDTO.class);
    }


    public boolean deleteEmployeeById(Long id, boolean delete) {
        if(delete && employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public EmployeeDTO updateEmployeePartiallyById(Long id, Map<String, String> updates) {
        Optional<EmployeeEntity> emp = employeeRepo.findById(id);
        if (emp.isEmpty()) return null;
        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(EmployeeEntity.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field,emp.get(),value);
        });
        return modelMapper.map(employeeRepo.save(emp.get()),EmployeeDTO.class);
    }
}
