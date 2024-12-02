package com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.homework.respositories;

import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.homework.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Long> {
}
