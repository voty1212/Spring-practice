package com.srinivasan.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

  public FootballCoach(){
      System.out.println("Football");
  }
   //Init method
    @PostConstruct
    public void domywork(){
        System.out.println(getClass().getSimpleName());
    }
    @PreDestroy
    public void cleanmywork(){
        System.out.println(getClass().getSimpleName());
    }

    @Override
    public String dailyworkout(){

        return "Practice Shooting!!";
    }
}
