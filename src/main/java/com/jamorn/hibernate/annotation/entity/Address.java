package com.jamorn.hibernate.annotation.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by sunyameng on 14-4-3.
 */
@Entity
@Table(name="a_address")
public class Address {
    private Integer id;
    private String address;
    private Customer customer;
    public Address(){}
    public Address(String address,Customer customer){
        this.address=address;
        this.customer=customer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "address",nullable = false,length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToOne(optional = false,mappedBy = "address",cascade =CascadeType.ALL )
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
