package com.yurets_y.mapping.one_to_many;

import com.yurets_y.lazy_init_example.entity.HeadEntity;
import com.yurets_y.mapping.one_to_many.bidirectional.HeadEntityBidir;
import com.yurets_y.mapping.one_to_many.bidirectional.SubEntityBidir;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToManyDAO <Head,Child,ID> {

    private final Class<Head> headClass;

    private final Class<Child> childClass;

    private EntityManager entityManager;

    public OneToManyDAO(Class<Head> headClass, Class<Child> childClass) {
        this.headClass = headClass;
        this.childClass = childClass;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("one_to_many_mapping_persistence");
        this.entityManager = emf.createEntityManager();
    }

    public void saveHeadEntity(Head entity){
        beginTransaction();
        entityManager.persist(entity);
        commitTransaction();
    }

    public void saveSubEntity(Child entity){
        beginTransaction();
        entityManager.persist(entity);
        commitTransaction();
    }

    public Head loadHeadEntityById(ID id){
        beginTransaction();
        Head entity = entityManager.find(headClass,id);
        commitTransaction();
        return entity;
    }

    public Child loadSubEntityById(Long id){
        beginTransaction();
        Child entity = entityManager.find(childClass,id);
        commitTransaction();
        return entity;
    }

    private void beginTransaction(){
        entityManager.getTransaction().begin();
    }

    private void commitTransaction(){
        entityManager.getTransaction().commit();
    }

    public void closeEntityManager(){
        entityManager.close();
    }

}
