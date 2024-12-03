package com.codingshuttle.springbootwebtutorial.Springbootwebtutorial.homework.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Department")
@Data
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private Boolean isActive;

    private LocalDate createdAt;
}
