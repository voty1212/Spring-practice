package com.srinivasan.springboot.cruddemo.service;

import com.srinivasan.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findall();
    Employee findbyid(int id);
    Employee save(Employee theEmployee);
    void deletebyid(int id);

}
