package com.jamie.cards.controller;


import com.jamie.cards.bean.FriendDTO;
import com.jamie.cards.service.FriendRequestService;
import com.jamie.cards.service.FriendService;
import com.jamie.cards.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FriendController {

    @Autowired
    private UserService userService;

    @Autowired
    private FriendService friendService;

    @Autowired
    private FriendRequestService friendRequestService;

    @RequestMapping(value = "v1/friends", method = RequestMethod.GET)
    public ResponseEntity<List<FriendDTO>> getFriends(@RequestParam String loginToken) {
        long userId = userService.loginWithToken(loginToken);
        return new ResponseEntity<>(friendService.getFriends(userId), HttpStatus.OK);
    }

    @RequestMapping(value = "v1/friendRequests", method = RequestMethod.GET)
    public ResponseEntity<?> getFriendRequests(@RequestParam String loginToken) {
        long userId = userService.loginWithToken(loginToken);
        friendRequestService.getFriendRequests(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "v1/friendRequest", method = RequestMethod.POST)
    public ResponseEntity<?> sendOrAcceptRequest(@RequestParam String loginToken, @RequestParam Long friendId) {
        long userId = userService.loginWithToken(loginToken);
        friendRequestService.addFriendRequest(userId, friendId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "v1/friendRequest", method = RequestMethod.DELETE)
    public ResponseEntity<?> cancelOrDeclineRequest(@RequestParam String loginToken, @RequestParam Long friendId) {
        long userId = userService.loginWithToken(loginToken);
        friendRequestService.deleteFriendRequest(userId, friendId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
