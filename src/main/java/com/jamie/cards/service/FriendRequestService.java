package com.jamie.cards.service;

import com.jamie.cards.entity.FriendRequest;

import java.util.List;

public interface FriendRequestService {
    List<FriendRequest> getFriendRequests(long userId);

    void addFriendRequest(long userId, Long friendId);

    void deleteFriendRequest(long userId, Long friendId);
}
