package com.srinivasan.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FootballCoach implements Coach{
    @Override
    public String dailyworkout(){
        System.out.println("Football");
        return "Practice Shooting!!";
    }
}
