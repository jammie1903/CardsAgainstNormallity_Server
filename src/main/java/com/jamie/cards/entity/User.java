package com.jamie.cards.entity;

import com.jamie.cards.bean.AuthenticationDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "user")
public class User {

    @Id
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String loginToken;

    @Column
    private Date lastReadDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public Date getLastReadDate() {
        return lastReadDate;
    }

    public void setLastReadDate(Date lastReadDate) {
        this.lastReadDate = lastReadDate;
    }
}
