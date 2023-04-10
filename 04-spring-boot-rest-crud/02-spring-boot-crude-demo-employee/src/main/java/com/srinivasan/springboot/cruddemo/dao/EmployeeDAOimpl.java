package com.srinivasan.springboot.cruddemo.dao;

import com.srinivasan.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOimpl implements EmployeeDAO{
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOimpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public List<Employee> findall() {
        //Create query
        TypedQuery<Employee> typedQuery=entityManager.createQuery("FROM Employee",Employee.class);
        List<Employee> employeelist=typedQuery.getResultList();
        return employeelist;

    }

    @Override
    public Employee findbyid(int id) {
        //get employee by id
        Employee employee=entityManager.find(Employee.class,id);

        //return the employee

        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //save employee
        Employee employee=entityManager.merge(theEmployee);
        //return employee
        return employee;
    }

    @Override
    public void deletebyid(int id) {
         //find employee
        Employee employee=entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }
}
