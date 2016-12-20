package com.jamie.cards.service.impl;

import com.jamie.cards.bean.FriendDTO;
import com.jamie.cards.entity.Friend;
import com.jamie.cards.repository.FriendRepository;
import com.jamie.cards.repository.UserRepository;
import com.jamie.cards.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendRepository friendRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<FriendDTO> getFriends(Long userId) {
        List<Friend> friends = friendRepository.findByUserId(userId);
        List<Long> friendIds = friends.stream().map((f) -> userId.equals(f.getUserId1()) ? f.getUserId2() : f.getUserId1()).collect(Collectors.toList());
        return userRepository.findFriends(friendIds);
    }

    @Override
    public void addFriend(Long userId, Long friendId) {
        Friend friend = new Friend();
        friend.setUserId1(userId);
        friend.setUserId2(friendId);
        friendRepository.save(friend);
    }
}
