package com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private LocalDate dateOfJoining;

    private Boolean isActive;

}
