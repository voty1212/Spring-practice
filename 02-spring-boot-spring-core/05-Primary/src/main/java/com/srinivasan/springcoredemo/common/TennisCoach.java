package com.srinivasan.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    @Override
    public String dailyworkout() {
        System.out.println("Tennis");
        return "Swinging practice";
    }
}
