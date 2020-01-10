package com.yurets_y.mapping.one_to_many.entity;

import javax.persistence.*;

@Entity
public class Email {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    private String domain;

    private String name;

    private Boolean active;

    public Email() {
    }

    public Email(String domain, String name) {
        this.domain = domain;
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getFullAddress(){
        return name + "@" + domain;
    }

    @Override
    public String toString() {
        return "Email{" +
                "active=" + active +
                "employee=" + employee +
                "email=" + getFullAddress() +
                '}';
    }
}
