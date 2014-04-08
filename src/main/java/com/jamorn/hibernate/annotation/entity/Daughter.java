package com.jamorn.hibernate.annotation.entity;

import javax.persistence.*;

/**
 * Created by yameng on 2014/4/8.
 */
@Entity
@Table(name="a_daughter")
public class Daughter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    @ManyToOne(optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "mother_id",unique = true)
    private Mother mother;
    public Daughter() {
    }
    public Daughter(String name,Integer age,Mother mother){
        this.name=name;
        this.age=age;
        this.mother=mother;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }
}
