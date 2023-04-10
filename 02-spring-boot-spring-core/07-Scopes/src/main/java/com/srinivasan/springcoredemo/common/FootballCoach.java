package com.srinivasan.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

  public FootballCoach(){
      System.out.println("Football");
  }
    @Override
    public String dailyworkout(){

        return "Practice Shooting!!";
    }
}
