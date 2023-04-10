package com.srinivasan.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{
    @Override
    public String dailyworkout(){
        return "Practice Shooting!!";
    }
}
