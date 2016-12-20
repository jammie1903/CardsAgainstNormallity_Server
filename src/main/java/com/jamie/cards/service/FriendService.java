package com.jamie.cards.service;


import com.jamie.cards.bean.FriendDTO;
import com.jamie.cards.entity.Friend;

import java.util.List;

public interface FriendService {
    List<FriendDTO> getFriends(Long userId);

    void addFriend(Long userId, Long friendId);
}
