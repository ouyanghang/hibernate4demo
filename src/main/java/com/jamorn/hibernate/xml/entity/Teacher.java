package com.jamorn.hibernate.xml.entity;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by yameng on 2014/4/8.
 */
public class Teacher {
    private Integer id;
    private String name;
    private Set<Student> students=new HashSet<>();

    public Teacher(){}
    public Teacher(String name){
        this.name=name;
    }
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
