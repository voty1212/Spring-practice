package com.srinivasan.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String dailyworkout() {
        System.out.println("Track");
        return "Run 5k";
    }
}
