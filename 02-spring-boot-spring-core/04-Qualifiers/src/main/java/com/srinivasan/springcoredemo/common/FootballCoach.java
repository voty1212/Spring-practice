package com.srinivasan.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{
    @Override
    public String dailyworkout(){
        return "Practice Shooting!!";
    }
}
