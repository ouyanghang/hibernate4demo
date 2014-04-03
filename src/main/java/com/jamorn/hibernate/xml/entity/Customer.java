package com.jamorn.hibernate.xml.entity;

/**
 * Created by yameng on 2014/4/3.
 */
public class Customer {
    private Long id;
    private String name;
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
