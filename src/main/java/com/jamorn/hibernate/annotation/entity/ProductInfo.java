package com.jamorn.hibernate.annotation.entity;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

/**
 * Created by sunyameng on 2014/4/6.
 */
@Entity
@Table(name="a_productInfo")
public class ProductInfo {

    private Integer id;
    private String info;
    private Product product;
    public ProductInfo(){}
    public ProductInfo(String info){
        this.info=info;
    }



    @Id @GeneratedValue(generator = "copy")
    @GenericGenerator(name="copy",strategy = "foreign",parameters = @Parameter(name = "property",value="product"))
    @Column
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    @OneToOne
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
