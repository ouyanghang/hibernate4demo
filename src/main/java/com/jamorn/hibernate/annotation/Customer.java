package com.jamorn.hibernate.annotation;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sunyameng on 14-4-3.
 */
@Entity
public class Customer implements Serializable{
    private Long id;
    private String name;
    private Integer age;
    private Address address;
    @Version @Column(name="OPTLOCK")
    private Integer version;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
