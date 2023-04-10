package com.Srinivasan.demo.MySpring.rest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@org.springframework.web.bind.annotation.RestController
public class RestControl {
   @GetMapping("/")
    public String sayHello(){
       return "Hello World";
   }
}
