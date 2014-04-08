package com.jamorn.hibernate.xml.entity;

import java.util.Set;

/**
 * Created by sunyameng on 2014/4/6.
 */
public class Parent {
    private Integer id;
    private String name;
    private Set<Child> children;
    public Parent(){}
    public Parent(String name,Set<Child> children){
        this.name=name;
        this.children=children;
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

    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }
}
