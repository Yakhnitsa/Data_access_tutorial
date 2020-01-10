package com.yurets_y.mapping.one_to_many_vs_composite_id.entity;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "accountNumber"),
            @JoinColumn(name = "accountType")
    })
    private Account account;

    private String message;

    private String tag;

    public Message() {
    }

    public Message(String tag, String message) {
        this.message = message;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
