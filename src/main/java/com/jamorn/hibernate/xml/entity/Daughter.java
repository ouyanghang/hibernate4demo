package com.jamorn.hibernate.xml.entity;

/**
 * Created by yameng on 2014/4/8.
 */
public class Daughter {
    private Integer id;
    private String name;
    private Integer age;
    private Mother mother;
    public Daughter() {
    }
    public Daughter(String name,Integer age,Mother mother){
        this.mother=mother;
        this.name=name;
        this.age=age;
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
