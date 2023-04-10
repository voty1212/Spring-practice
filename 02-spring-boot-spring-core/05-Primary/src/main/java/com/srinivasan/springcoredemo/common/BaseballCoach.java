package com.srinivasan.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String dailyworkout(){
        System.out.println("Baseball");
        return "Batting practice";
    }
}
