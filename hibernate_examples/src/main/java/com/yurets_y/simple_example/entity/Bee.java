package com.yurets_y.simple_example.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.text.MessageFormat;

@Entity
public class Bee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bee_gen")
    @SequenceGenerator(name = "bee_gen", sequenceName = "bee_id_seq")
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn
    private Honey honey;

    public Bee() {}
    public Bee(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Honey getHoney() {
        return honey;
    }
    public void setHoney(Honey honey) {
        this.honey = honey;
    }
    public String toString() {
        return MessageFormat.format("{0}: id={1}, name={2}", new Object[] {
                getClass().getSimpleName(), id, name });
    }
}
