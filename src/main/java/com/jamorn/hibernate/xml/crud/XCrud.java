package com.jamorn.hibernate.xml.crud;

import com.jamorn.hibernate.util.HibernateSessionFactory;
import com.jamorn.hibernate.xml.entity.Address;
import com.jamorn.hibernate.xml.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by yameng on 2014/4/3.
 */
public class XCrud {
    public static void create(){
        Session session= HibernateSessionFactory.getSession();
        Transaction transaction=session.beginTransaction();
        try {
            Customer customer=new Customer();
            customer.setName("aaa");
            Address address=new Address();
            address.setAddress("addfd");
            address.setCustomer(customer);
            customer.setAddress(address);

            session.save(customer);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }
    public static void query(){
        Session session= HibernateSessionFactory.getSession();
        try {
            Customer customer=(Customer)session.createQuery("select customer from Customer customer where customer.id=:id").setParameter("id",new Long(1)).uniqueResult();
            System.out.println(customer.getName()+" "+customer.getAddress().getAddress());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }
    public static void main(String[] args) {
        XCrud.create();
        XCrud.query();
    }
}
