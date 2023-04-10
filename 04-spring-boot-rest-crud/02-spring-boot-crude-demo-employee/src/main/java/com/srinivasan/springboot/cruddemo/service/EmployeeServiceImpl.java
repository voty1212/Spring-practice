package com.srinivasan.springboot.cruddemo.service;

import com.srinivasan.springboot.cruddemo.dao.EmployeeDAO;
import com.srinivasan.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO)
    {
        this.employeeDAO=employeeDAO;
    }
    @Override
    public List<Employee> findall() {
        return employeeDAO.findall();
    }

    @Override
    public Employee findbyid(int id) {
        return employeeDAO.findbyid(id);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deletebyid(int id) {
        employeeDAO.deletebyid(id);
    }
}
