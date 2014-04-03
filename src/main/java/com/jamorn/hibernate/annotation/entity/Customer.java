package com.jamorn.hibernate.annotation.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sunyameng on 14-4-3.
 */
@Entity
@Table(name = "a_customer")
public class Customer implements Serializable{
    private Long id;
    private String name;
    private Integer age;
    private Address address;
    public Customer(){}
    public Customer(String name,Integer age){
        this.name=name;
        this.age=age;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="name",nullable = false,length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(optional = false,mappedBy = "customer",cascade = CascadeType.ALL)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(name="age",nullable = false)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
