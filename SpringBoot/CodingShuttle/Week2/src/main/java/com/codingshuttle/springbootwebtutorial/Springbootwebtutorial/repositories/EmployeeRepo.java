package com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.repositories;


import com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {
}
