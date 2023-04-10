package com.srinivasan.springcoredemo.rest;

import com.srinivasan.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach coach;
  @Autowired
  public void doCoach(Coach coach){
      this.coach=coach;
  }
    @GetMapping("/dailyworkout")
    public String dailyworkout(){
        return coach.dailyworkout();
    }
}
