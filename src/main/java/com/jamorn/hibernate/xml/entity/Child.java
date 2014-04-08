package com.jamorn.hibernate.xml.entity;

/**
 * Created by sunyameng on 2014/4/6.
 */
public class Child {
    private Integer id;
    private String name;
    public Child(){}
    public Child(String name){
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
}
