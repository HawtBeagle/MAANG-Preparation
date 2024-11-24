package com.codingshuttle.Introduction.Week1.Doubts;

import org.springframework.stereotype.Component;

@Component
public class EmployeeTest {

  private EmployeeClass emp;
  private EmployeeRecord empRecord;

  public EmployeeTest(EmployeeClass emp, EmployeeRecord empRecord) {
    this.emp = emp;
    this.empRecord = empRecord;
  }

  public void runForClass() {
    System.out.println(emp);
    System.out.println(emp.hashCode());
  }

  public void runForRecord() {
    System.out.println(emp);
    System.out.println(emp.hashCode());
  }
}
