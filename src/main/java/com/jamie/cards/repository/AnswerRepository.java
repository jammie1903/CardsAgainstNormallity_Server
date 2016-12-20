package com.jamie.cards.repository;

import com.jamie.cards.entity.Answer;
import com.jamie.cards.entity.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
    List<Answer> findByUserId(Long userId);
}
