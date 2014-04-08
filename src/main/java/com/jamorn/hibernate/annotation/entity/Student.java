package com.jamorn.hibernate.annotation.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yameng on 2014/4/8.
 */
@Entity
@Table(name = "a_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "students")
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
