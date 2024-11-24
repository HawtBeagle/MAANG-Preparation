package com.codingshuttle.Introduction.Week1.Doubts;

import org.springframework.stereotype.Component;

@Component
public class EmployeeClass {
    private final String name;
    private final int age;

    public EmployeeClass() {
        this.name = "bhanu";
        this.age = 22;
    }
    public EmployeeClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "EmployeeClass(name = "+name+", "+"age = "+age+")";
    }

}
