package com.jamie.cards.service.impl;

import com.jamie.cards.entity.Answer;
import com.jamie.cards.entity.Question;
import com.jamie.cards.repository.AnswerRepository;
import com.jamie.cards.repository.QuestionRepository;
import com.jamie.cards.service.AnswerService;
import com.jamie.cards.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public List<Answer> getByUserId(Long userId) {
        return answerRepository.findByUserId(userId);
    }

    @Override
    public List<Answer> getByGame(Long gameId) {
        return null;//TODO
    }

    @Override
    public void create(Long userId, String text) {
        Answer answer = new Answer();
        answer.setText(text);
        answer.setUserId(userId);
        answerRepository.save(answer);
    }

    @Override
    public void update(Long userId, long cardId, String text) {
        Answer answer = answerRepository.findOne(cardId);
        if(answer != null && answer.getUserId().equals(userId)) {
            answer.setText(text);
            answerRepository.save(answer);
        } else {
            throw new UnsupportedOperationException("Card does not exist or card does not belong to current user");
        }
    }

    @Override
    public void delete(Long userId, long cardId) {
        Answer answer = answerRepository.findOne(cardId);
        if(answer != null && answer.getUserId().equals(userId)) {
            answerRepository.delete(answer);
        } else {
            throw new UnsupportedOperationException("Card does not exist or card does not belong to current user");
        }
    }
}
