package com.jamorn.hibernate.crud;

import com.jamorn.hibernate.entity.Site;
import com.jamorn.hibernate.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * Created by yameng on 14-4-2.
 */
public class CRUD {
    public static void create(){
        Session session= HibernateSessionFactory.getSession();
        Transaction transaction=session.beginTransaction();
        try {
            Site site=new Site();
            site.setCode("one");
            site.setName("amorn");
            site.setCreateTime(new Date());

            session.save(site);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }

    public static void query(){
        Session session=HibernateSessionFactory.getSession();
        Transaction transaction=session.beginTransaction();
        try {
            Site site=(Site)session.createQuery("select site from Site site where site.id=:id").setParameter("id",new Long(1)).uniqueResult();
            System.out.println(site.getName());
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }finally {
            HibernateSessionFactory.closeSession();
        }

    }
    public static void main(String[] args) {
        //CRUD.query();
        CRUD.create();
    }
}
