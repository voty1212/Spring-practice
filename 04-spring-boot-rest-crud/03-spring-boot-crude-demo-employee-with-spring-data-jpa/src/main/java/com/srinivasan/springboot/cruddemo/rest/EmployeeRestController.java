package com.srinivasan.springboot.cruddemo.rest;

import com.srinivasan.springboot.cruddemo.entity.Employee;
import com.srinivasan.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    //inject employee dao
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService theemployeeService){
        employeeService=theemployeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findall(){
        return employeeService.findall();
    }
    @GetMapping("/employees/{employeeId}")//the name under brackets should be same as that of the argument passed below
    public Employee findbyId(@PathVariable int employeeId){
        Employee newemployee=employeeService.findbyid(employeeId);
        if(newemployee==null)
            throw new RuntimeException("none found");
        return newemployee;
    }
    //add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theemployee)
    {
        theemployee.setId(0);//in case the employee has an id , this will force it to 0 i.e new employee
        Employee dbemployee=employeeService.save(theemployee);
        return dbemployee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbemployee=employeeService.save(employee);
        return dbemployee;
    }
    @DeleteMapping("/employees/{employeeid}")
    public String deleteEmployee(@PathVariable int employeeid)
    {
        Employee dbemployee=employeeService.findbyid(employeeid);
        if(dbemployee==null)
            throw new RuntimeException("Not found");
        employeeService.deletebyid(employeeid);
        return "Deleted id "+employeeid;
    }

}
