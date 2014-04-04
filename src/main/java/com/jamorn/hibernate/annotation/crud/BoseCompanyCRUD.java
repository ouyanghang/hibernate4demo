package com.jamorn.hibernate.annotation.crud;

import com.jamorn.hibernate.annotation.entity.Bose;
import com.jamorn.hibernate.annotation.entity.Company;
import com.jamorn.hibernate.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by sunyameng on 14-4-4.
 */
public class BoseCompanyCRUD {
    public static void create(){
        Session session= HibernateSessionFactory.getSession();
        Transaction transaction=session.beginTransaction();
        try {
            Bose bose = new Bose("superman");
            Company company = new Company("supercompany");
            bose.setCompany(company);
            company.setBose(bose);
            session.save(company);
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
            Company company=(Company)session.createQuery("select company from Company company where company.id=:id").setParameter("id", 1).uniqueResult();
            System.out.println(company.getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }
    public static void main(String[] args) {
        AdressCustomerCRUD.create();
    }
}
