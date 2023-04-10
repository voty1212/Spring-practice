package com.srinivasan.springboot.cruddemo.service;

import com.srinivasan.springboot.cruddemo.dao.EmployeeRepository;
import com.srinivasan.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository)
    {
        this.employeeRepository=employeeRepository;
    }
    @Override
    public List<Employee> findall() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findbyid(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee=null;
        if(result.isPresent()){
            employee=result.get();
        }
        return employee;    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
  
    public void deletebyid(int id) {
        employeeRepository.deleteById(id);
    }
}
