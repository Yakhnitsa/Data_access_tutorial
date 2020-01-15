package com.yurets_y.lazy_init_example.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table
public class HeadEntity {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(
            mappedBy = "headEntity",
            fetch = FetchType.LAZY,
            cascade=CascadeType.ALL,
            orphanRemoval = true)
    private Set<ChildrenEntity> childSet = new HashSet<ChildrenEntity>();

    private String name;

    private String type;

    public HeadEntity() {
    }

    public HeadEntity(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ChildrenEntity> getChildSet() {
        return childSet;
    }

    public void setChildSet(Set<ChildrenEntity> childSet) {
        this.childSet = childSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Iterator<ChildrenEntity> iterator() {
        return childSet.iterator();
    }

    public boolean add(ChildrenEntity childrenEntity) {
        childrenEntity.setHeadEntity(this);
        return childSet.add(childrenEntity);
    }

    public boolean remove(Object o) {
        return childSet.remove(o);
    }

    @Override
    public String toString() {
        return "HeadEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
