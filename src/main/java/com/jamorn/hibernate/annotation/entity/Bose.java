package com.jamorn.hibernate.annotation.entity;

import javax.persistence.*;

/**
 * Created by sunyameng on 14-4-4.
 */
@Entity
@Table(name="a_bose")
public class Bose {
    private Integer id;
    private String name;
    private Company company;
    public Bose(){}
    public Bose(String name){
        this.name=name;
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "name",nullable = false,length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @OneToOne(optional = false,cascade =CascadeType.ALL )
    @JoinTable(name = "company_bose",
            joinColumns = @JoinColumn(name="company_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="bose_id",referencedColumnName="id")
    )
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
