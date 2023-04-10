package com.srinivasan.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    public BaseballCoach(){
        System.out.println("Baseball");
    }
    @Override
    public String dailyworkout(){
        return "Batting practice";
    }
}
