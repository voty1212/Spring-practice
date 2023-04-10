package com.srinivasan.springcoredemo.rest;

import com.srinivasan.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  DemoController {
    private Coach coach;
    private Coach anotherCoach;
  @Autowired
  public DemoController(@Qualifier("baseballCoach") Coach coach,
                        @Qualifier("baseballCoach") Coach theanotherCoach){
      System.out.println(getClass().getSimpleName());
      anotherCoach=theanotherCoach;
      this.coach=coach;
  }
    @GetMapping("/dailyworkout")
    public String dailyworkout(){
        return coach.dailyworkout();}

    @GetMapping("/check")
    public String check(){
        return "Comparing beans "+(anotherCoach==this.coach);
        }



    }

