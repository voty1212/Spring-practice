package com.srinivasan.springcoredemo.common;

public class SwimCoach implements Coach{
    public SwimCoach(){
        System.out.println(getClass().getSimpleName());
    }
    @Override
    public String dailyworkout() {
        return "Swim 1k";
    }
}
