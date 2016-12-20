package com.jamie.cards.repository;

import com.jamie.cards.entity.FriendRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendRequestRepository extends CrudRepository<FriendRequest, Long> {

    @Query("select f from com.jamie.cards.entity.FriendRequest f where f.requesterId = ?1 or f.requesteeId = ?1")
    List<FriendRequest> findByUserId(Long userId);

    @Query("select f from com.jamie.cards.entity.FriendRequest f where (f.requesterId = ?1 and f.requesteeId = ?2) or (f.requesterId = ?2 and f.requesteeId = ?1)")
    FriendRequest findByUserIds(Long userId, Long userId2);


}
