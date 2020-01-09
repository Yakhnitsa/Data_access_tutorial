package com.yurets_y.core.hibernate.hibernate_simple_example.util;

import com.yurets_y.core.hibernate.hibernate_simple_example.entity.Auto;
import com.yurets_y.core.hibernate.hibernate_simple_example.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;
import java.io.File;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                File configFile = new File("src/main/java/com/yurets_y/core/hibernate/hibernate_simple_example/configuration/hibernate.cfg.xml");
                Configuration configuration = new Configuration().configure(configFile);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Auto.class);
                sessionFactory = configuration.buildSessionFactory();
                

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}