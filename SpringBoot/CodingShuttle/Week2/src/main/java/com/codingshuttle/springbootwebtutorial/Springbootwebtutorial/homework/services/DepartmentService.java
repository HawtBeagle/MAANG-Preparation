package com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.homework.services;

import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.homework.dtos.DepartmentDTO;
import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.homework.entities.DepartmentEntity;
import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.homework.respositories.DepartmentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private DepartmentRepo departmentRepo;

    private ModelMapper modelMapper;

    public DepartmentService(DepartmentRepo departmentRepo, ModelMapper modelMapper) {
        this.departmentRepo = departmentRepo;
        this.modelMapper = modelMapper;
    }

    public List<DepartmentDTO> getAllDepartments() {
       List<DepartmentEntity> departmentEntities = departmentRepo.findAll();
       return departmentEntities
               .stream()
               .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
               .collect(Collectors.toList());
    }

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity department = modelMapper.map(departmentDTO, DepartmentEntity.class);
        return modelMapper.map(departmentRepo.save(department),DepartmentDTO.class);
    }
}
