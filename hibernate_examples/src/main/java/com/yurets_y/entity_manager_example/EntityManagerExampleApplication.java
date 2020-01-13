package com.yurets_y.entity_manager_example;

import com.yurets_y.entity_manager_example.entity.SimpleEntity;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class EntityManagerExampleApplication {
    public static void main(String[] args) {
        createEntityManager();
    }

    private static void createEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity-manager-example-persistence");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        SimpleEntity sm1 = new SimpleEntity("First entity",new Date(),"Simple");
        SimpleEntity sm2 = new SimpleEntity("Second entity",new Date(),"Simple");
        SimpleEntity sm3 = new SimpleEntity("Third entity",new Date(),"Simple");

        entityManager.persist(sm1);
        entityManager.persist(sm2);
        entityManager.persist(sm3);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
