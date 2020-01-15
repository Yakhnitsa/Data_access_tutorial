package com.yurets_y.lazy_init_example;

import com.yurets_y.lazy_init_example.entity.ChildrenEntity;
import com.yurets_y.lazy_init_example.entity.HeadEntity;
import com.yurets_y.lazy_init_example.repo.HeadEntityRepo;

import java.sql.SQLOutput;
import java.util.Set;

public class LazyInitExampleApplication {
    public static void main(String[] args) {
        notInitializedTest();
        try{
            notInitializedTest();
        }catch(Exception e){
            System.out.println("Ошибка во время выполнения " + e.getMessage());
        }

        initializedTest();
    }
    private static void notInitializedTest(){
        System.out.println("Начало теста без инициализации");
        HeadEntityRepo headRepo = new HeadEntityRepo();
        HeadEntity entityFromRepo = headRepo.getById(1L);
        //Закрываем соединение с БД для невозможности загрузить запрашиваемые поля
        headRepo.close();

        System.out.println(entityFromRepo);
        System.out.println("Not initialized " + entityFromRepo.getChildSet().size());
        entityFromRepo.getChildSet().forEach(System.out::println);
        System.out.println("Конец теста без инициализации");
    }

    private static void initializedTest(){
        HeadEntityRepo headRepo = new HeadEntityRepo();
        HeadEntity entityFromRepo = headRepo.getInitializedById(1L);
        //Закрываем соединение с БД для невозможности загрузить запрашиваемые поля
        headRepo.close();

        System.out.println(entityFromRepo);
        System.out.println("Initialized " + entityFromRepo.getChildSet().size());
        entityFromRepo.getChildSet().forEach(System.out::println);
    }
}
