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
    public static void saveSite(){
        Site site=new Site("demo",new Date());
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
    /* load 方法特征
     * (1) 如果数据库中没有匹配的identity，会抛异常
     * (2) load 默认返回一个未初始化的代理对象，并没有hit数据库，直到调用了该代理对象的方法时，才真正hit数据库，初始化代理对象
     * (3) load 如果在session边界外调用未初始化的代理对象的方法，将发生异常
     */
    public static void querySiteByLoad(){
        Site site=null;
        Session session = HibernateSessionFactory.getSession();
        try {
            site=(Site)session.load(Site.class, new Long(1));
            System.out.println(site.toString());//如果注释掉，下面的打印语句会报错
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            HibernateSessionFactory.closeSession();
        }
        System.out.println(site.toString());
    }
    /*
     * get 方法特征
     * (1) 如果数据库中没有匹配的identity,返回null
     * (2) 如果session中已经存在该持久化对象，直接返回，如果没有，直接hit数据库，并返回持久化对象，而不是代理对象
     */
    public static void querySiteByGet(){
        Site site=null;
        Session session = HibernateSessionFactory.getSession();
        try {
            site=(Site)session.get(Site.class, (long) 1);
            //System.out.println(site.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            HibernateSessionFactory.closeSession();
        }
        System.out.println(site.toString());
    }
    public static void saveChannel(){
        Channel channel1=new Channel("channel1",new Date());
        Channel channel2=new Channel("channel2",new Date());
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Site site=(Site)session.get(Site.class, (long) 1);
            site.addChannel(channel1);
            site.addChannel(channel2);
            //此处可以使用 save,update,saveOrUpdate
            //在此处是用persist会有很大不同，如果设置了cascade=PERSIST，将会级联查询对象，然后在实例化，会产生很多sql
            session.save(site);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }finally{
            HibernateSessionFactory.closeSession();
        }
    }
    public static void saveContent(){
        Content content1=new Content("content1",new Date());
        Content content2=new Content("content2",new Date());
        Content content3=new Content("content3",new Date());
        Content content4=new Content("content4",new Date());

        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Channel channel1 = (Channel) session.get(Channel.class, (long) 1);
            Channel channel2 = (Channel) session.get(Channel.class, (long) 2);
            channel1.addContent(content1);
            channel1.addContent(content2);
            channel2.addContent(content3);
            channel2.addContent(content4);
            /**
             * 当查询channel的时候，ManyToOne默认的fetch方式是EAGER，所以会将关联的site也查询出来，
             * 默认的查询方式是外连接查询，如：
             *  select
                     channel0_.id as id1_1_0_,
                     channel0_.createTime as createTi2_1_0_,
                     channel0_.name as name3_1_0_,
                     channel0_.site_id as site_id4_1_0_,
                     site1_.id as id1_8_1_,
                     site1_.createTime as createTi2_8_1_,
                     site1_.name as name3_8_1_
                from
                     a_channel channel0_
                left outer join
                     a_site site1_
                on channel0_.site_id=site1_.id
                where
                     channel0_.id=?
             */
            session.save(channel1);
            session.save(channel2);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }finally{
            HibernateSessionFactory.closeSession();
        }
    }
    public static void HQLquery1(){
        Site site=null;
        Session session = HibernateSessionFactory.getSession();
        try {
            site=(Site)session.createQuery("from Site as site where site.id=?").setLong(0,1).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            HibernateSessionFactory.closeSession();
        }
        System.out.println(site);

    }
    public static void main(String[] args) {
//        A_SiteCRUD.saveSite();
//        A_SiteCRUD.querySiteByLoad();
//        A_SiteCRUD.querySiteByGet();
//        A_SiteCRUD.saveChannel();
//        A_SiteCRUD.saveContent();
        A_SiteCRUD.HQLquery1();
    }
}
