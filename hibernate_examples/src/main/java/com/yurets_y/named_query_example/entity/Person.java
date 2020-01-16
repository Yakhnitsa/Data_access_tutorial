package com.yurets_y.named_query_example.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name="findByName",query="SELECT p FROM Person p WHERE p.name LIKE :personName"),
        @NamedQuery(name="findByDateOfBirth", query = "SELECT p FROM Person p WHERE p.dateOfBirth between :dateFrom and :dateTo"),
        @NamedQuery(name="findBySalary", query = "SELECT p from Person p WHERE p.salary > :salary")
})

public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String lastName;

    private int salary;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    public Person() {
    }

    public Person(String name, String lastName, Date dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
