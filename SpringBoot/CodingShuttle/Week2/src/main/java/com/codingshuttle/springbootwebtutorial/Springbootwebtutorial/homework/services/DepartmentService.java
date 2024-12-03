package com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.homework.services;

import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.homework.dtos.DepartmentDTO;
import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.homework.entities.DepartmentEntity;
import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.homework.respositories.DepartmentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.rmi.UnexpectedException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
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
        try{
            return modelMapper.map(departmentRepo.save(department),DepartmentDTO.class);
        }catch (Exception e) {
            throw new RuntimeException("Unable to save");
        }
    }

    public DepartmentDTO updateDepartmentById(Long id, DepartmentDTO departmentDTO) {
        DepartmentEntity department = modelMapper.map(departmentDTO, DepartmentEntity.class);
        department.setId(id);
        try {
            return modelMapper.map(departmentRepo.save(department), DepartmentDTO.class);
        }catch (Exception e) {
            throw new RuntimeException("Unable to save department");
        }
    }

    public Boolean deleteDepartmentById(Long id) {
        if (departmentRepo.existsById(id)) {
            departmentRepo.deleteById(id);
            return true;
        }
        else throw new NoSuchElementException("Department not found");
    }

    public DepartmentDTO updateDepartmentPartiallyById(Long id, Map<String, Object> updates) {
        DepartmentEntity department = modelMapper.map(departmentRepo.findById(id).orElseThrow(() ->  new NoSuchElementException("Department not found")), DepartmentEntity.class);
            updates.forEach(
                    (key, value) -> {
                        Field field = ReflectionUtils.findField(DepartmentEntity.class, key);
                        assert field != null: "field not found";
                        field.setAccessible(true);
                        ReflectionUtils.setField(field, department, value);
                    }
            );
            return modelMapper.map(department, DepartmentDTO.class);
    }

}
