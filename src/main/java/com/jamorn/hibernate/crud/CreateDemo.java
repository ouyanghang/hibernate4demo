package com.jamorn.hibernate.crud;

import com.jamorn.hibernate.entity.Site;
import com.jamorn.hibernate.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * Created by sunyameng on 14-4-2.
 */
public class CreateDemo {
    public static void main(String[] args) {
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
}
