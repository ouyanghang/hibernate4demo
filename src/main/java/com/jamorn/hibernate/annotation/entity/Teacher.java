package com.jamorn.hibernate.annotation.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yameng on 2014/4/8.
 */
@Entity
@Table(name="a_teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="a_teacher_student",joinColumns={@JoinColumn(name="teacher_id")},
                inverseJoinColumns = {@JoinColumn(name="student_id")})
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
