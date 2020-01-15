package com.yurets_y.lazy_init_example.repo;

import java.util.Set;

public interface EntityRepo <Entity, Id> {

    Entity save(Entity b);

    Entity getById(Id id);

    Entity getInitializedById(Id id);

    void delete(Entity b);

    Set<Entity> getAll();

    void close();

}
