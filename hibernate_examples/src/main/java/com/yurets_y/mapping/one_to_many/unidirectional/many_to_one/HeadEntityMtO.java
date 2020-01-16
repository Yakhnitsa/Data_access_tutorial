package com.yurets_y.mapping.one_to_many.unidirectional.many_to_one;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "HEAD_ENTITY_UNIDIR_MANY_TO_ONE")
public class HeadEntityMtO {
    @Id
    private Long id;

    private String name;

    public HeadEntityMtO() {
    }

    public HeadEntityMtO( String name, Long id) {
        this.id = id;
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "HeadEntityMtO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
