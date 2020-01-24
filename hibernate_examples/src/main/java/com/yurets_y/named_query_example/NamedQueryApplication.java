package com.yurets_y.named_query_example;

import com.yurets_y.named_query_example.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NamedQueryApplication {
    private static EntityManager en;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws Exception {
        initDB();
        executeQueries();
        en.close();
    }

    static{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("named-query-persistence");
        en = emf.createEntityManager();
    }

    private static void executeQueries() throws ParseException{
        List<Person> resultList = en.createNamedQuery("findByName",Person.class)
                .setParameter("personName","Jason")
                .getResultList();
        resultList.forEach(System.out::println);

        System.out.println("find by salary result");
        resultList = en.createNamedQuery("findBySalary",Person.class)
                .setParameter("salary",60000)
                .getResultList();
        resultList.forEach(System.out::println);

        System.out.println("find by age result (Age less than 50 years");
        Date dateFrom = dateFormat.parse("1970-01-17");
        Date dateTill = new Date();
        resultList = en.createNamedQuery("findByDateOfBirth",Person.class)
                .setParameter("dateFrom",dateFrom)
                .setParameter("dateTo",dateTill)
                .getResultList();
        resultList.forEach(System.out::println);

    }

    private static void initDB() throws ParseException {
        Person person1 = new Person("Dwayne","Johnson",100000, dateFormat.parse("1972-05-02"));
        Person person2 = new Person("Jason","Statham",50000, dateFormat.parse("1967-07-26"));
        Person person3 = new Person("Vin","Diesel",80000, dateFormat.parse("1967-05-18"));
        Person person4 = new Person("Paul","Walker",50000, dateFormat.parse("1973-09-12"));
        Person person5 = new Person("Idrissa","Elba",60000, dateFormat.parse("1972-09-06"));
        Person person6 = new Person("Bruce","Willis", 100000, dateFormat.parse("1955-03-19"));
        Person person7 = new Person("Sylvester","Stallone",120000, dateFormat.parse("1946-07-06"));

        en.getTransaction().begin();
        en.persist(person1);
        en.persist(person2);
        en.persist(person3);
        en.persist(person4);
        en.persist(person5);
        en.persist(person6);
        en.persist(person7);
        en.getTransaction().commit();
    }
}
