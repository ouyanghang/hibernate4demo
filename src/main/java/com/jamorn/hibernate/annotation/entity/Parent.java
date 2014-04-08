package com.jamorn.hibernate.annotation.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by sunyameng on 2014/4/6.
 */
@Entity
@Table(name="a_parent")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id",nullable = false)
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
