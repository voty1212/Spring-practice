package com.srinivasan.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
   public TennisCoach(){
       System.out.println("Tennis");
   }
    @Override
    public String dailyworkout() {

        return "Swinging practice";
    }
}
