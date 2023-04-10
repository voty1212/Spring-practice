package com.srinivasan.springboot.cruddemo.dao;

import com.srinivasan.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //that's it.....
}
