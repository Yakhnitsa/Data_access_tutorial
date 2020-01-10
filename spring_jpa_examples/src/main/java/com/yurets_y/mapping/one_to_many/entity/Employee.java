package com.yurets_y.mapping.one_to_many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="employee_id")
    private Long id;

    @Column(name="EMPLOYEE_NAME")
    private String name;

    @Column(name="EMPLOYEE_LAST_NAME")
    private String lastName;


    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Email> emails = new ArrayList<>();

    public Employee() {
    }

    public Employee(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public int size() {
        return emails.size();
    }

    public boolean isEmpty() {
        return emails.isEmpty();
    }

    public boolean contains(Object o) {
        return emails.contains(o);
    }

    public Iterator<Email> iterator() {
        return emails.iterator();
    }

    public boolean add(Email email) {
        email.setEmployee(this);
        return emails.add(email);
    }

    public boolean remove(Object o) {
        return emails.remove(o);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}