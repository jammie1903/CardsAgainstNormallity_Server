package com.jamie.cards.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "friendRequest")
public class FriendRequest {

    @Id
    private Long id;

    @Column
    private Long requesterId;

    @Column
    private Long requesteeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    public Long getRequesteeId() {
        return requesteeId;
    }

    public void setRequesteeId(Long requesteeId) {
        this.requesteeId = requesteeId;
    }
}
