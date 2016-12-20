package com.jamie.cards.repository;

import com.jamie.cards.entity.Friend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendRepository extends CrudRepository<Friend, Long> {

    @Query("select f from com.jamie.cards.entity.Friend f where f.userId1 = ?1 or f.userId2 = ?1")
    List<Friend> findByUserId(Long userId);
}
