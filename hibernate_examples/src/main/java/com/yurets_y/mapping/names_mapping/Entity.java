package com.yurets_y.mapping.names_mapping;


import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity(name="simpleEntity")
@Table(name="MY_ENTITY")
public class Entity {
    @Id
    private Long id;
}
