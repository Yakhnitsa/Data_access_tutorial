package com.yurets_y.mapping.composite_id_mapping.entity;

import java.io.Serializable;

public class AccountId implements Serializable {
    private String accountNumber;

    private String accountType;

    public AccountId() {
    }


    public AccountId(String accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountId accountId = (AccountId) o;

        if (accountNumber != null ? !accountNumber.equals(accountId.accountNumber) : accountId.accountNumber != null)
            return false;
        return accountType != null ? accountType.equals(accountId.accountType) : accountId.accountType == null;
    }

    @Override
    public int hashCode() {
        int result = accountNumber != null ? accountNumber.hashCode() : 0;
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        return result;
    }

}
