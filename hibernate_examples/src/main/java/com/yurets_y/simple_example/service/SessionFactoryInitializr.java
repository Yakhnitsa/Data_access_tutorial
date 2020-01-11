package com.yurets_y.simple_example.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryInitializr {
    /** The single instance of hibernate SessionFactory */
    private static org.hibernate.SessionFactory sessionFactory;
    private SessionFactoryInitializr() {
    }
    static {
        final Configuration cfg = new Configuration();
        cfg.configure("/simple_example_res/hibernate.cfg.xml");
        sessionFactory = cfg.buildSessionFactory();
    }
    public static SessionFactory getInstance() {
        return sessionFactory;
    }
}
