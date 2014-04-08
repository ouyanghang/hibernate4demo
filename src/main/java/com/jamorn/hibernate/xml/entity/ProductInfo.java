package com.jamorn.hibernate.xml.entity;

/**
 * Created by sunyameng on 2014/4/6.
 */
public class ProductInfo {
    private Integer id;
    private String info;
    private Product product;
    public ProductInfo(){}
    public ProductInfo(String info){
        this.info=info;
    }
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
