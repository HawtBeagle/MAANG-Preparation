package com.codingshuttle.Introduction.Week1.Doubts;

import org.springframework.stereotype.Component;

@Component
public record EmployeeRecord(String name, int age) {

    public EmployeeRecord() {
        this("bhanu", 22);
    }
}
