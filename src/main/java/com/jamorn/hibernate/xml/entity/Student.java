package com.jamorn.hibernate.xml.entity;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by yameng on 2014/4/8.
 */
public class Student {
    private Integer id;
    private String name;
    private Set<Teacher> teachers=new HashSet<>();
    public Student(String name){
        this.name=name;
    }
    public Student(){}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
