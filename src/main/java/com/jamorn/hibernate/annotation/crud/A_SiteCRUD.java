package com.jamorn.hibernate.annotation.crud;

import com.jamorn.hibernate.annotation.entity.Channel;
import com.jamorn.hibernate.annotation.entity.Site;
import com.jamorn.hibernate.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * Created by sunyameng on 2014/4/9.
 */
public class A_SiteCRUD {
    public static void create(){
        Site site=new Site("demo",new Date());
        Channel channel=new Channel("channel1",new Date(),site);
        site.getChannels().add(channel);

        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(site);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }finally{
            HibernateSessionFactory.closeSession();
        }
    }
    public static void main(String[] args) {
        A_SiteCRUD.create();
    }
}
