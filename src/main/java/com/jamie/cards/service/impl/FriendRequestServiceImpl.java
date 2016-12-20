package com.jamie.cards.service.impl;

import com.jamie.cards.entity.FriendRequest;
import com.jamie.cards.repository.FriendRequestRepository;
import com.jamie.cards.service.FriendRequestService;
import com.jamie.cards.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendRequestServiceImpl implements FriendRequestService {

    @Autowired
    private FriendRequestRepository friendRequestRepository;

    @Autowired
    private FriendService friendService;

    @Override
    public List<FriendRequest> getFriendRequests(long userId) {
        return friendRequestRepository.findByUserId(userId);
    }

    @Override
    public void addFriendRequest(long userId, Long friendId) {
        FriendRequest request = friendRequestRepository.findByUserIds(userId, friendId);
        if (request != null) {
            if (request.getRequesteeId().equals(userId)) {
                friendService.addFriend(userId, friendId);
                friendRequestRepository.delete(request);
            }
        } else {
            request = new FriendRequest();
            request.setRequesterId(userId);
            request.setRequesteeId(friendId);
        }
    }

    @Override
    public void deleteFriendRequest(long userId, Long friendId) {
        FriendRequest request = friendRequestRepository.findByUserIds(userId, friendId);
        if (request != null) {
            friendRequestRepository.delete(request);
        }
    }
}
