package com.jamorn.hibernate.annotation.entity;

import javax.persistence.*;

/**
 * Created by sunyameng on 14-4-4.
 */
@Entity
@Table(name="a_company")
public class Company {
    private Integer id;
    private String name;
    private Bose bose;
    public Company(){}
    public Company(String name){
        this.name=name;
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name="name",nullable = true,length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @OneToOne(optional = false,cascade =CascadeType.ALL )
    @JoinColumn(name="bose_id")
    public Bose getBose() {
        return bose;
    }

    public void setBose(Bose bose) {
        this.bose = bose;
    }
}
