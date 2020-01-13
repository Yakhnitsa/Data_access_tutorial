# Построение Hibernate приоложения с использованием Entity Manager

1. Настраиваем конфигурацию Hibernate:
    В файле resources/META-INF/persistence.xml прописываем persistence под именем name="entity-manager-example-persistence"
    ВАЖНОЕ ЗАМЕЧАНИЕ:
            <!--Прописываем классы, попадающие в маппинк-->
            <class>com.yurets_y.entity_manager_example.entity.SimpleEntity</class>
            <exclude-unlisted-classes>true</exclude-unlisted-classes>
    Иначе таблицы создатутсядля всех Entity, найденных в проекте.


2. Создаем Entity manager factory
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity-manager-example-persistence");
3. Создаем транзакцию и сохраняем сущности:
    EntityManager entityManager = emf.createEntityManager();
    entityManager.getTransaction().begin();
    entityManager.persist(Object 1);
    entityManager.persist(Object 2);
    entityManager.persist(Object 3);

    entityManager.getTransaction().commit();
    entityManager.close();

## Required dependencies:
    <dependency>
        <groupId>com.h2database</groupId>
          <artifactId>h2</artifactId>
          <version>1.4.190</version>
      </dependency>
      <dependency>
         <groupId>org.hibernate</groupId>
         <artifactId>hibernate-entitymanager</artifactId>
         <version>5.1.0.Final</version>
      </dependency>