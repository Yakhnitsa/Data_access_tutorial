package com.yurets_y.lazy_ititialization_example.entity;

import javax.persistence.*;
import java.util.HashSet;
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
            cascade=CascadeType.REMOVE,
            orphanRemoval = true)
    private Set<ChildrenEntity> childSet = new HashSet<ChildrenEntity>();
}
