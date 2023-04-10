package com.Srinivasan.demo.MySpring.rest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@org.springframework.web.bind.annotation.RestController
public class RestControl {

    //Injecting Properties

    @Value("${coach.name}")
    private String coachname;

    @Value("${team.name}")
    private String teamname;

    //New endpoints

    @GetMapping("/team")
    public String getTeamInfo(){
        return "Coach: "+coachname+", Team name: "+teamname;
    }
   @GetMapping("/")
    public String sayHello(){
       return "Hello World";
   }

//expose new end point for workout
@GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run 5k";
        }
@GetMapping("&am")
     public String Keep(){
       return "Hello";
}
        }