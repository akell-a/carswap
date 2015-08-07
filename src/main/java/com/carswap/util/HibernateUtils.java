package com.carswap.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by hackomotto on 07.08.15.
 */
public class HibernateUtils {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static Session getSession(){
        return getSessionFactory().openSession();
    }
}
