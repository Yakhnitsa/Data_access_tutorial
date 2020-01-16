package com.yurets_y.mapping.one_to_many.unidirectional.many_to_one;

import javax.persistence.*;

@Entity
@Table(name= "CHILD_ENTITY_UNIDIR_MANY_TO_ONE")
public class SubEntityMtO {
    @Id
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="HEAD_ID")
    private HeadEntityMtO headEntity;

    public SubEntityMtO() {
    }

    public SubEntityMtO(String name, Long id) {
        this.id = id;
        this.name = name;
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

    public HeadEntityMtO getHeadEntity() {
        return headEntity;
    }

    public void setHeadEntity(HeadEntityMtO headEntity) {
        this.headEntity = headEntity;
    }

    @Override
    public String toString() {
        return "SubEntityMtO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", headEntity=" + headEntity +
                '}';
    }
}
