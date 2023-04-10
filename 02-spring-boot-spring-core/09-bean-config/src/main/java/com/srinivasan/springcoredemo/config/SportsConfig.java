package com.srinivasan.springcoredemo.config;

import com.srinivasan.springcoredemo.common.Coach;
import com.srinivasan.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {
    @Bean("water")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
