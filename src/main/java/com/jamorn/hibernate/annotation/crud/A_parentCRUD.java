package com.jamorn.hibernate.annotation.crud;

import com.jamorn.hibernate.annotation.entity.Child;
import com.jamorn.hibernate.annotation.entity.Parent;
import com.jamorn.hibernate.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sunyameng on 2014/4/6.
 */
public class A_ParentCRUD {
    public static void create() {
        //维护双向关系
        Child tom = new Child("tom");
        Child jack = new Child("jack");
        Set<Child> children=new HashSet<>();
        children.add(tom);
        children.add(jack);
        Parent parent=new Parent("superman",children);

        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(parent);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }

    public static void main(String[] args) {
        A_ParentCRUD.create();
    }
}
