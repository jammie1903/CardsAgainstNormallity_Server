package com.jamie.cards.service;

import com.jamie.cards.entity.Card;
import com.jamie.cards.entity.Question;

import java.util.List;

public interface CardService<C extends Card> {
    List<C> getByUserId(Long userId);
    List<C> getByGame(Long gameId);
    void create(Long userId, String text);
    void update(Long userId, long cardId, String text);
    void delete(Long userId, long cardId);
}
