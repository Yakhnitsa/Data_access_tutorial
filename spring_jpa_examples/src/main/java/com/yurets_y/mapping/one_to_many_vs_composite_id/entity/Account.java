package com.yurets_y.mapping.one_to_many_vs_composite_id.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@IdClass(Account.AccountId.class)
public class Account {
    @Id
    private String accountNumber;

    @Id
    private String accountType;



    private String userName;

    private String userEmail;

    @OneToMany(mappedBy = "account",
            cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Message> messages = new HashSet<>();

    public Account() {
    }

    public Account(String accountType, String accountNumber) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

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

    public Iterator<Message> iterator() {
        return messages.iterator();
    }

    public boolean add(Message message) {
        return messages.add(message);
    }

    public boolean remove(Object o) {
        return messages.remove(o);
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


    public static class AccountId implements Serializable {
        private String accountNumber;

        private String accountType;

        public AccountId() {
        }


        public AccountId(String accountType,String accountNumber) {
            this.accountNumber = accountNumber;
            this.accountType = accountType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AccountId accountId = (AccountId) o;

            if (!accountNumber.equals(accountId.accountNumber)) return false;
            return accountType.equals(accountId.accountType);
        }

        @Override
        public int hashCode() {
            int result = accountNumber.hashCode();
            result = 31 * result + accountType.hashCode();
            return result;
        }
    }
}
