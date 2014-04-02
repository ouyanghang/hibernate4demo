package com.jamorn.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by sunyameng on 14-4-2.
 */
public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static String configFile = "/hibernate.cfg.xml";

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure(configFile);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Exception e) {
            System.err.println("%%%% Error Creating SessionFactory %%%%");
            e.printStackTrace();
        }
    }

    private HibernateSessionFactory() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() throws HibernateException {
        Session session = threadLocal.get();
        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession() : null;
            threadLocal.set(session);
        }
        return session;
    }

    public static void closeSession() throws HibernateException {
        Session session = threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
            session.close();
        }
    }

    public static void rebuildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure(configFile);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Exception e) {
            System.err.println("%%%% Error Creating SessionFactory %%%%");
            e.printStackTrace();
        }
    }

    public static void setConfigFile(String configFile) {
        HibernateSessionFactory.configFile = configFile;
        sessionFactory = null;
    }
}
