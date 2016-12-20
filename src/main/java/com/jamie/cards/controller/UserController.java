package com.jamie.cards.controller;

import com.jamie.cards.bean.AuthenticationDetails;
import com.jamie.cards.entity.Answer;
import com.jamie.cards.entity.Question;
import com.jamie.cards.entity.User;
import com.jamie.cards.service.AnswerService;
import com.jamie.cards.service.QuestionService;
import com.jamie.cards.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "v1/ping", method = RequestMethod.GET)
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }

    @RequestMapping(value = "v1/login", method = RequestMethod.POST)
    public ResponseEntity<AuthenticationDetails> login(@RequestBody User details) {
        return new ResponseEntity<>(userService.login(details), HttpStatus.OK);
    }

    @RequestMapping(value = "v1/user", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody User details) {
        return new ResponseEntity<>(userService.createUser(details), HttpStatus.OK);
    }
}
