package com.yurets_y.entity_manager_example.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ENTITY_EXAMPLE")
public class SimpleEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="ENTITY_NAME")
    private String name;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name="ENTITY_TYPE")
    private String type;

    public SimpleEntity() {
    }

    public SimpleEntity(String name, Date date, String type) {
        this.name = name;
        this.date = date;
        this.type = type;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
