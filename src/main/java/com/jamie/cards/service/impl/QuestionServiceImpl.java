package com.jamie.cards.service.impl;

import com.jamie.cards.entity.Question;
import com.jamie.cards.repository.QuestionRepository;
import com.jamie.cards.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> getByUserId(Long userId) {
        return questionRepository.findByUserId(userId);
    }

    @Override
    public List<Question> getByGame(Long gameId) {
        return null;//TODO
    }

    @Override
    public void create(Long userId, String text) {
        Question question = new Question();
        question.setText(text);
        question.setUserId(userId);
        questionRepository.save(question);
    }

    @Override
    public void update(Long userId, long cardId, String text) {
        Question question = questionRepository.findOne(cardId);
        if(question != null && question.getUserId().equals(userId)) {
            question.setText(text);
            questionRepository.save(question);
        } else {
            throw new UnsupportedOperationException("Card does not exist or card does not belong to current user");
        }
    }

    @Override
    public void delete(Long userId, long cardId) {
        Question question = questionRepository.findOne(cardId);
        if(question != null && question.getUserId().equals(userId)) {
            questionRepository.delete(question);
        } else {
            throw new UnsupportedOperationException("Card does not exist or card does not belong to current user");
        }
    }
}
