package com.srinivasan.springboot.thymeleafdemo.service;

import com.srinivasan.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void deleteById(int theId);
}
