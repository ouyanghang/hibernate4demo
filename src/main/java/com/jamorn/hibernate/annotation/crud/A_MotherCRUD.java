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
            Mother mother=new Mother("MM",30);
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

    /**
     * mother daughter 一对多的关系，如果要持久化一个daughter，且该daughter关联了一个数据库中已经存在的mother，
     * 如果是双向关联，保存之前应该先load出这个mother，然后在保存
     * 如果是单向关联，即在多的一方不配置 casacade，那么可以直接保存
     */
    public static void create2(){
        Session session= HibernateSessionFactory.getSession();
        Transaction transaction=session.beginTransaction();
        try {
//            Mother mother= (Mother) session.load(Mother.class,1);
            Mother mother=new Mother();
            mother.setId(1);
            Daughter ximorn=new Daughter();
            ximorn.setName("xcvb");
            ximorn.setAge(10);
            ximorn.setMother(mother);
            session.save(ximorn);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }
    public static void main(String[] args) {
        A_MotherCRUD.create2();
    }
}
