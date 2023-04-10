package com.srinivasan.springboot.thymeleafdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;

@Controller
public class DemoController {
    //create a mapping for "/hello"
    @GetMapping("/hello")
    public String sayhello(Model model)
    {
        model.addAttribute("theDate",new java.util.Date());
        return "helloworld";
    }
}
