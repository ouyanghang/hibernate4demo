package com.jamorn.hibernate.annotation.crud;

import com.jamorn.hibernate.annotation.entity.Daughter;
import com.jamorn.hibernate.annotation.entity.Mother;
import com.jamorn.hibernate.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yameng on 2014/4/8.
 */
public class A_MotherCRUD {
    public static void create(){
        Session session= HibernateSessionFactory.getSession();
        Transaction transaction=session.beginTransaction();
        try {
            Mother mother=new Mother("MM");
            Daughter lucy=new Daughter("lucy",20,mother);
            Daughter lili=new Daughter("lili",18,mother);
            Daughter ximorn=new Daughter("ximorn",23,mother);
            Set<Daughter> daughters=new HashSet<>();
            daughters.add(lucy);
            daughters.add(lili);
            daughters.add(ximorn);
            mother.setDaughters(daughters);
            session.save(mother);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }
    public static void main(String[] args) {
        A_MotherCRUD.create();
    }
}
