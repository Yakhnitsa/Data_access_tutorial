package com.yurets_y.core.spring_jpa.mapping.compositeId_mapping.entity;

@Entity
@IdClass(AccountId.class)
public class Account {
    @Id
    private String accountNumber;

    @Id
    private String accountType;

    // other fields, getters and setters
}