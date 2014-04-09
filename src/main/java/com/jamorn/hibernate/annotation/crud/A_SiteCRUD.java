package com.jamorn.hibernate.annotation.crud;

import com.jamorn.hibernate.annotation.entity.Channel;
import com.jamorn.hibernate.annotation.entity.Content;
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
        Channel channel1=new Channel("channel1",new Date());
        Channel channel2=new Channel("channel2",new Date());
        site.addChannel(channel1);
        site.addChannel(channel2);

//
//        Content content1=new Content("content1",new Date());
//        Content content2=new Content("content2",new Date());
//        Content content3=new Content("content3",new Date());
//        Content content4=new Content("content4",new Date());
//
//        channel1.addContent(content1);
//        channel1.addContent(content3);
//        channel2.addContent(content2);
//        channel2.addContent(content4);
//
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            //session.save(site);
//            session.save(channel1);
//            session.save(channel2);
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
