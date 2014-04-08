package com.jamorn.hibernate.xml.entity;

/**
 * Created by sunyameng on 2014/4/6.
 */
public class Product {
    private Integer id;
    private String name;
    private ProductInfo productInfo;
    public Product(){}
    public Product(String name,ProductInfo productInfo){
        this.name=name;
        this.productInfo=productInfo;
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

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }
}
