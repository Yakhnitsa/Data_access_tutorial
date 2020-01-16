package com.yurets_y.mapping.one_to_many;

import com.yurets_y.mapping.one_to_many.bidirectional.HeadEntityBidir;
import com.yurets_y.mapping.one_to_many.bidirectional.SubEntityBidir;
import com.yurets_y.mapping.one_to_many.unidirectional.many_to_one.HeadEntityMtO;
import com.yurets_y.mapping.one_to_many.unidirectional.many_to_one.SubEntityMtO;
import com.yurets_y.mapping.one_to_many.unidirectional.one_to_many.HeadEntityOtM;
import com.yurets_y.mapping.one_to_many.unidirectional.one_to_many.SubEntityOtM;



public class OneToManyMappingApplication {

    public static void main(String[] args) {
//        bidirectionalOneToMany();
//        unidirectionalOneToMany();
        unidirectionalManyToOne();
    }

    private static void bidirectionalOneToMany(){
        OneToManyDAO<HeadEntityBidir,SubEntityBidir,Long> bidirectionalDao = new OneToManyDAO<>(HeadEntityBidir.class,SubEntityBidir.class);

        HeadEntityBidir headEntity = new HeadEntityBidir("Head",1L);

        headEntity.add(new SubEntityBidir("Child1"));
        headEntity.add(new SubEntityBidir("Child2"));
        headEntity.add(new SubEntityBidir("Child3"));
        headEntity.add(new SubEntityBidir("Child4"));


        bidirectionalDao.saveHeadEntity(headEntity);

        HeadEntityBidir entityFromDB = bidirectionalDao.loadHeadEntityById(1L);


        bidirectionalDao.closeEntityManager();
        System.out.println(entityFromDB);
        entityFromDB.getSubEntities().forEach(System.out::println);
    }

    private static void unidirectionalOneToMany(){
        OneToManyDAO<HeadEntityOtM,SubEntityOtM,Long> unidirectionalDao = new OneToManyDAO<>(HeadEntityOtM.class,SubEntityOtM.class);

        HeadEntityOtM headEntity = new HeadEntityOtM("head",1L);
        headEntity.add(new SubEntityOtM("child1"));
        headEntity.add(new SubEntityOtM("child2"));
        headEntity.add(new SubEntityOtM("child3"));
        headEntity.add(new SubEntityOtM("child4"));

        unidirectionalDao.saveHeadEntity(headEntity);

        HeadEntityOtM entityFromDB =  unidirectionalDao.loadHeadEntityById(1L);

        System.out.println(entityFromDB);
        entityFromDB.getChildSet().forEach(System.out::println);

        unidirectionalDao.closeEntityManager();

    }

    private static void unidirectionalManyToOne(){
        OneToManyDAO<HeadEntityMtO,SubEntityMtO,Long> dao = new OneToManyDAO<>(HeadEntityMtO.class,SubEntityMtO.class);

        HeadEntityMtO head = new HeadEntityMtO("head",1L);

        SubEntityMtO child1 = new SubEntityMtO("Child1",1L);
        SubEntityMtO child2 = new SubEntityMtO("Child2",2L);
        SubEntityMtO child3 = new SubEntityMtO("Child3",3L);
        child1.setHeadEntity(head);
        child2.setHeadEntity(head);
        child3.setHeadEntity(head);

        HeadEntityMtO head2 = new HeadEntityMtO("head2",2L);

        SubEntityMtO child4 = new SubEntityMtO("Child1",4L);
        SubEntityMtO child5 = new SubEntityMtO("Child2",5L);
        SubEntityMtO child6 = new SubEntityMtO("Child3",6L);
        child4.setHeadEntity(head2);
        child5.setHeadEntity(head2);
        child6.setHeadEntity(head2);

        dao.saveSubEntity(child1);
        dao.saveSubEntity(child2);
        dao.saveSubEntity(child3);
        dao.saveSubEntity(child4);
        dao.saveSubEntity(child5);
        dao.saveSubEntity(child6);

        SubEntityMtO childFromDB1 = dao.loadSubEntityById(1L);
        SubEntityMtO childFromDB3 = dao.loadSubEntityById(3L);
        SubEntityMtO childFromDB5 = dao.loadSubEntityById(5L);

        System.out.println(childFromDB1);
        System.out.println(childFromDB3);
        System.out.println(childFromDB5);
        System.out.println("Проверка на идентичность " + (childFromDB1.getHeadEntity() == childFromDB3.getHeadEntity()));

        dao.closeEntityManager();

    }
}
