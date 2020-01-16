package com.yurets_y.mapping.one_to_many.bidirectional;


import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "HEAD_ENTITY_BIDIRECTIONAL")
public class HeadEntityBidir {
    @Id
    private Long id;

    private String name;

    public HeadEntityBidir() {
    }

    public HeadEntityBidir(String name,Long id) {
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "headEntity")
    private Set<SubEntityBidir> subEntities = new HashSet<>();

    public Set<SubEntityBidir> getSubEntities() {
        return Collections.unmodifiableSet(subEntities);
    }

    public boolean add(SubEntityBidir subEntity) {
        subEntity.setHeadEntity(this);
        return subEntities.add(subEntity);
    }

    public boolean remove(SubEntityBidir subEntity) {
        subEntity.setHeadEntity(null);
        return getSubEntities().remove(subEntity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeadEntityBidir{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subEntities=" + subEntities +
                '}';
    }
}
