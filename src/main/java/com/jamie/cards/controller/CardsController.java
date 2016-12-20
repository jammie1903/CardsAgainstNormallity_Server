package com.jamie.cards.controller;

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
public class CardsController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @RequestMapping(value = "v1/questions", method = RequestMethod.GET)
    public ResponseEntity<List<Question>> getUsersQuestionDeck(@RequestParam String token) {
        Long userId = userService.loginWithToken(token);
        return new ResponseEntity<>(questionService.getByUserId(userId), HttpStatus.OK);
    }

    @RequestMapping(value = "v1/answers", method = RequestMethod.GET)
    public ResponseEntity<List<Answer>> getUsersAnswerDeck(@RequestParam String token) {
        Long userId = userService.loginWithToken(token);
        return new ResponseEntity<>(answerService.getByUserId(userId), HttpStatus.OK);
    }

    @RequestMapping(value = "v1/question", method = RequestMethod.POST)
    public ResponseEntity<?> createQuestion(@RequestParam String token, @RequestParam String text) {
        Long userId = userService.loginWithToken(token);
        questionService.create(userId, text);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @RequestMapping(value = "v1/answer", method = RequestMethod.POST)
    public ResponseEntity<?> createAnswer(@RequestParam String token, @RequestParam String text) {
        Long userId = userService.loginWithToken(token);
        answerService.create(userId, text);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @RequestMapping(value = "v1/question", method = RequestMethod.PUT)
    public ResponseEntity<?> updateQuestion(@RequestParam String token, @RequestParam Long cardId, @RequestParam String text) {
        Long userId = userService.loginWithToken(token);
        questionService.update(userId, cardId, text);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "v1/answer", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAnswer(@RequestParam String token, @RequestParam Long cardId, @RequestParam String text) {
        Long userId = userService.loginWithToken(token);
        answerService.update(userId, cardId, text);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "v1/question", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteQuestion(@RequestParam String token, @RequestParam Long cardId) {
        Long userId = userService.loginWithToken(token);
        questionService.delete(userId, cardId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "v1/answer", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAnswer(@RequestParam String token, @RequestParam Long cardId) {
        Long userId = userService.loginWithToken(token);
        answerService.delete(userId, cardId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
