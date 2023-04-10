package com.srinivasan.demo.rest;

import com.srinivasan.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRest {

    private List<Student> theStudents;
    //define @PostConstruct to load student data just once
    @PostConstruct
    public void loadData(){
        theStudents=new ArrayList<>();
        theStudents.add(new Student("Srinivasan R","Bashyam"));
        theStudents.add(new Student("Lionel","Messi"));
        theStudents.add(new Student("Mason","Mount"));
    }
    //define endpoint for students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;

    }
    //define endpoint for /students/(studentId)
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //index in the list
        //chech the studentId in list size
        if((studentId>=theStudents.size()||studentId<0))
        {
            throw new StudentNotFoundException(("Student id not found "+studentId));
        }
        return theStudents.get(studentId);
    }




    //Exception handler

}
