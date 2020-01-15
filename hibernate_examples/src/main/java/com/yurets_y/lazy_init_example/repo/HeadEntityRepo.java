package com.yurets_y.lazy_init_example.repo;

import com.yurets_y.lazy_init_example.entity.HeadEntity;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

public class HeadEntityRepo implements EntityRepo<HeadEntity,Long> {

    private EntityManager entityManager;

    public HeadEntityRepo() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lazy-init-example-persistence");
        entityManager = emf.createEntityManager();

    }

    @Override
    public HeadEntity save(HeadEntity b) {
        beginTransaction();
        entityManager.persist(b);
        commitTransaction();
        return b;
    }

    @Override
    public HeadEntity getById(Long id) {
        beginTransaction();
        HeadEntity entity = entityManager.find(HeadEntity.class,id);
        commitTransaction();
        return entity;
    }

    @Override
    public void delete(HeadEntity b) {
        beginTransaction();
        entityManager.remove(b);
        commitTransaction();
    }

    @Override
    public Set<HeadEntity> getAll() {
        beginTransaction();

        Set<HeadEntity> entities = entityManager.createQuery("from HeadEntity",HeadEntity.class)
                .getResultStream().
                collect(Collectors.toSet());
        commitTransaction();
        return entities;
    }

    @Override
    public HeadEntity getInitializedById(Long id) {
        beginTransaction();
        HeadEntity entity = entityManager.find(HeadEntity.class, id);
        Hibernate.initialize(entity.getChildSet());
        return entity;
    }

    @Override
    public void close(){
        entityManager.close();
    }

    private void beginTransaction(){
        entityManager.getTransaction().begin();
    }

    private void commitTransaction(){
        entityManager.getTransaction().commit();

    }


}
