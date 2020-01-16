package com.yurets_y.mapping.one_to_many.unidirectional.one_to_many;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "CHILD_ENTITY_UNIDIR_ONE_TO_MANY")
public class SubEntityOtM {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public SubEntityOtM() {
    }

    public SubEntityOtM(String name) {
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

    @Override
    public String toString() {
        return "SubEntityOtM{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
