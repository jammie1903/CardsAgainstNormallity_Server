package com.jamie.cards.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;

@Entity(name = "friend")
public class Friend {

    @Id
    private Long id;

    @Column
    private Long userId1;

    @Column
    private Long userId2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId1() {
        return userId1;
    }

    public void setUserId1(Long userId1) {
        this.userId1 = userId1;
    }

    public Long getUserId2() {
        return userId2;
    }

    public void setUserId2(Long userId2) {
        this.userId2 = userId2;
    }
}
