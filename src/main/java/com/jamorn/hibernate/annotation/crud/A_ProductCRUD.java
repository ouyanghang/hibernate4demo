package com.jamorn.hibernate.annotation.crud;

import com.jamorn.hibernate.annotation.entity.Product;
import com.jamorn.hibernate.annotation.entity.ProductInfo;
import com.jamorn.hibernate.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by sunyameng on 2014/4/6.
 */
public class A_ProductCRUD {
    public static void create() {
        //维护双向关系
        ProductInfo productInfo = new ProductInfo("made in china");
        Product product = new Product("Cup",productInfo);
        productInfo.setProduct(product);

        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }finally{
            HibernateSessionFactory.closeSession();
        }
    }

    public static void main(String[] args) {
        A_ProductCRUD.create();
    }
}
