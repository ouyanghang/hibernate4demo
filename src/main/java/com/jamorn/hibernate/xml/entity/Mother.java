package com.jamorn.hibernate.xml.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sunyameng on 2014/4/8.
 */
public class Mother {
    private Integer id;
    private String name;
    private Set<Daughter> daughters=new HashSet<>();
    public Mother(){}
    public Mother(String name){
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

    public Set<Daughter> getDaughters() {
        return daughters;
    }

    public void setDaughters(Set<Daughter> daughters) {
        this.daughters = daughters;
    }
}
