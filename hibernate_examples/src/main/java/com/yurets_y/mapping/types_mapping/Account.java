package com.yurets_y.mapping.types_mapping;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Account {

    @Id
    private Long id;

    @Id
    public Long getId() {
        return id;
    }

    @Column(name="USER_NAME", nullable=false) //отметка обязательного заполнения поля, экземпляр не будет сохраняться с пустым именем.
    @Access(AccessType.PROPERTY) //доступ к полю name через методы чтения-записи
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }
    @Column(name="IMPERIAL_WEIGHT")
    @org.hibernate.annotations.ColumnTransformer(
            read= "IMPERIAL_WEIGHT / 2.20462",
            write = "? * 2.20462"
    )// Трансформирование значения параметра при чтении-записи
    protected double metricWeight;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, updatable = false)
    @org.hibernate.annotations.Generated(org.hibernate.annotations.GenerationTime.ALWAYS)//Автоматическая генерация поля при обновлении данных
    private Date lastModified;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @org.hibernate.annotations.CreationTimestamp //Автоматически генерирует дату создания записи в таблице (не меняется при обновлении)
    protected Date createdOn;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
