package com.yurets_y.mapping.composite_id_mapping.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(AccountId.class)
public class Account {
    @Id
    private String accountNumber;

    @Id
    private String accountType;

    private String userName;

    private String userEmail;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (!accountNumber.equals(account.accountNumber)) return false;
        return accountType.equals(account.accountType);
    }

    @Override
    public int hashCode() {
        int result = accountNumber.hashCode();
        result = 31 * result + accountType.hashCode();
        return result;
    }
}
