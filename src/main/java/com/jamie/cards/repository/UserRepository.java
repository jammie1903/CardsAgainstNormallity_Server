package com.jamie.cards.repository;

import com.jamie.cards.bean.FriendDTO;
import com.jamie.cards.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByLoginToken(String loginToken);

    @Query("select new com.jamie.cards.bean.FriendDTO(u.id, u.username, u.lastReadDate) from com.jamie.cards.entity.User u where u.id in ?1")
    List<FriendDTO> findFriends(List<Long> friendIds);
}
