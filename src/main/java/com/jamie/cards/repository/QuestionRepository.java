package com.jamie.cards.repository;

import com.jamie.cards.entity.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findByUserId(Long userId);
}
