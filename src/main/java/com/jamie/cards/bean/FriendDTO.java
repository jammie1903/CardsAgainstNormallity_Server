package com.jamie.cards.bean;

import java.util.Date;

public class FriendDTO {
    private Long id;
    private String username;
    private Date lastActive;

    public FriendDTO() {
    }

    public FriendDTO(Long id, String username, Date lastActive) {
        this.id = id;
        this.username = username;
        this.lastActive = lastActive;
    }

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

    public Date getLastActive() {
        return lastActive;
    }

    public void setLastActive(Date lastActive) {
        this.lastActive = lastActive;
    }
}
