package com.srinivasan.springboot.cruddemo.dao;

import com.srinivasan.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findall();
    Employee findbyid(int id);
    Employee save(Employee theEmployee);
    void deletebyid(int id);

}
