package com.yurets_y.mapping.one_to_many.unidirectional.one_to_many;


import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "HEAD_ENTITY_UNIDIR_ONE_TO_MANY")
public class HeadEntityOtM {
    @Id
    private Long id;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="HEAD_ID", nullable=false)
    private Set<SubEntityOtM> childSet = new HashSet<>();

    private String name;


    public HeadEntityOtM() {
    }

    public HeadEntityOtM(String name,Long id) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean add(SubEntityOtM subEntityOtM) {
        return childSet.add(subEntityOtM);
    }

    public boolean remove(Object o) {
        return childSet.remove(o);
    }

    public Set<SubEntityOtM> getChildSet() {
        return Collections.unmodifiableSet(childSet);
    }

    @Override
    public String toString() {
        return "HeadEntityOtM{" +
                "id=" + id +
                ", childSet=" + childSet +
                ", name='" + name + '\'' +
                '}';
    }
}
