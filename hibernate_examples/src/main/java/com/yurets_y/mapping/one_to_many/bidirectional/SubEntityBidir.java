package com.yurets_y.mapping.one_to_many.bidirectional;


import javax.persistence.*;

@Entity
@Table(name= "CHILD_ENTITY_BIDIRECTIONAL")
public class SubEntityBidir {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_head_entity")
    private HeadEntityBidir headEntity;

    private String name;

    public SubEntityBidir() {
    }

    public SubEntityBidir(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HeadEntityBidir getHeadEntity() {
        return headEntity;
    }

    public void setHeadEntity(HeadEntityBidir headEntity) {
        this.headEntity = headEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SubEntityBidir{" +
                "headEntity=" + headEntity.getName() +
                ", name='" + name + '\'' +
                '}';
    }
}
