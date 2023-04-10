package com.srinivasan.springboot.thymeleafdemo.controller;

import com.srinivasan.springboot.thymeleafdemo.entity.Employee;
import com.srinivasan.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;



@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<Employee> theEmployees=employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
}
@GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model)
{
    //create model attribute to bind form data
    Employee employee=new Employee();
    model.addAttribute("employees",employee);
    return "employees/employee-form";
}

@PostMapping("/save")
    public String saveemployee(@Valid @ModelAttribute("employees") Employee employee, Errors errors)
{
      //saving employee
       if(null!=errors && errors.getErrorCount()>0)
       {
           return "employees/employee-form";
       }
       else {
           employeeService.save(employee);
           return "redirect:/employees/list";
       }


    //use a redirect to prevent duplicate entry

}
@GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
        //get the employee from the service
    Employee employee=employeeService.findById(theId);

    //set employee int the model
     theModel.addAttribute("employee",employee);

    //send to form
    return "employees/employee-form";
}
@GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){
        //delete user of given id
    employeeService.deleteById(id);
    return "redirect:/employees/list";
}
}
