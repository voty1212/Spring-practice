package com.srinivasan.cruddemo.dao;

import com.srinivasan.cruddemo.entity.student;

import java.util.*;

public interface studentdao {
    void save(student s);
    student findbyId(Integer id);
    List<student>  findall();
    List<student> findByLastName(String theLastName);
    void update(student s);
    void delete(Integer id);
    int deleteall();
 }
