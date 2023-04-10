package com.srinivasan.cruddemo.dao;

import com.srinivasan.cruddemo.entity.student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class studentdaoimpl implements studentdao{
    private EntityManager entityManager;
    @Autowired
    public studentdaoimpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(student ts){

       entityManager.persist(ts);
    }

    @Override
    public student findbyId(Integer id) {
        return entityManager.find(student.class,id);
    }

    @Override
    public List<student> findall() {
        //Query
        TypedQuery<student> typedQuery=entityManager.createQuery("FROM student",student.class);

        return typedQuery.getResultList();
    }

    @Override
    public List<student> findByLastName(String theLastName) {
        TypedQuery<student> typedQuery=entityManager.createQuery("FROM student where lastName=:theData",student.class);
        typedQuery.setParameter("theData",theLastName);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(student s) {
        entityManager.merge(s);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
       student s=entityManager.find(student.class,id);
       entityManager.remove(s);
    }

    @Override
    @Transactional
    public int deleteall() {
        int rows=entityManager.createQuery("DELETE from student").executeUpdate();
        return rows;
    }

}
