package com.yurets_y.lazy_ititialization_example.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ChildrenEntity {
    @ManyToOne
    private HeadEntity headEntity;

    public ChildrenEntity() {
    }


}
