package com.yurets_y.mapping.composite_id_mapping.entity;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class User {

    @EmbeddedId
    private UserId userId;

    private String email;

    private String nickName;

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
