package com.yurets_y.core.spring_jpa.mapping.compositeId_mapping.entity;

import java.io.Serializable;

public class AccountId implements Serializable {
    private String accountNumber;

    private String accountType;

    // default constructor

    public AccountId(String accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    // equals() and hashCode()
}