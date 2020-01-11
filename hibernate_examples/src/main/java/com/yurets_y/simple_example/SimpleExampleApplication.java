package com.yurets_y.simple_example;

import com.yurets_y.simple_example.entity.Honey;
import com.yurets_y.simple_example.service.SessionFactoryInitializr;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SimpleExampleApplication {
    public static void main(String[] args) {
        /* clean tables */
//        clean();
        /* simple create example */
        createHoney();
        /* relation example */
//        createRelation();
//        /* delete example */
//        delete();
//        /* update example */
//        update();
//        /* query example */
//        query();
    }

    private static Honey createHoney() {
        Honey forestHoney = new Honey();
        forestHoney.setName("forest honey");
        forestHoney.setTaste("very sweet");

        Session session = SessionFactoryInitializr.getInstance().openSession();

        Transaction tx = session.beginTransaction();
        session.save(forestHoney);
        tx.commit();
        session.close();
        return forestHoney;
    }

    private static void clean() {
        Session session = SessionFactoryInitializr.getInstance().openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from Bee").executeUpdate();
        session.createQuery("delete from Honey").executeUpdate();
        tx.commit();
        session.close();
    }
}
