package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class Demosecurityconfig {
    //add support for JDBC no hardcoding from now
    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
     //define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id,pw,active from members where user_id=?"//? parameter will be user name from login
                 );
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id,role from roles where user_id=?");



        return jdbcUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer->configurer.requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE"));
        http.authorizeHttpRequests(configurer->configurer.requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE"));
        http.authorizeHttpRequests(configurer->configurer.requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER"));
        http.authorizeHttpRequests(configurer->configurer.requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER"));
        http.authorizeHttpRequests(configurer->configurer.requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN"));
    //use HTTP Basic authentication
      http.httpBasic();
    //Disable Cross site request forgery(CSRF)
    //in general,not required for stateless REST APIs that use POST,PUT,DELETE
        http.csrf().disable();

return http.build();
    }
}
//@Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails Srini= User.builder()
//                .username("srini")
//                .password("{noop}test@123")
//                .roles("EMPLOYEE")
//                .build();
//        UserDetails Mary= User.builder()
//                .username("mary")
//                .password("{noop}test@123")
//                .roles("EMPLOYEE","MANAGER")
//                .build();
//        UserDetails Susan= User.builder()
//                .username("susan")
//                .password("{noop}test@123")
//                .roles("EMPLOYEE","MANAGER","ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(Srini,Mary,Susan);
//    }