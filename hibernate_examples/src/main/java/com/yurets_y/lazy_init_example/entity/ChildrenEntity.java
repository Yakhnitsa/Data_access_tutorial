package com.yurets_y.lazy_init_example.entity;

import javax.persistence.*;

@Entity
public class ChildrenEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private HeadEntity headEntity;

    private String name;

    private String lastName;

    public ChildrenEntity() {
    }

    public ChildrenEntity(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HeadEntity getHeadEntity() {
        return headEntity;
    }

    public void setHeadEntity(HeadEntity headEntity) {
        this.headEntity = headEntity;
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
}
