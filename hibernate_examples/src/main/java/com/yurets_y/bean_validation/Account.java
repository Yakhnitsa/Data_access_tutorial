package com.yurets_y.bean_validation;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
public class Account {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message="please enter the name")
    @Size(min=2,max=255)
    private String name;

    @Size(min=6,max=255,message="password must be more than 6 and less than 255 characters")
    private String password;


    @Past(message="creation time may not be in the future")
    private Date creationTime;

    @Email(message="Invalid email address")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }
}
