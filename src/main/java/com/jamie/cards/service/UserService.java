package com.jamie.cards.service;

import com.jamie.cards.bean.AuthenticationDetails;
import com.jamie.cards.entity.User;
import com.jamie.cards.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface UserService {
    AuthenticationDetails login(User details);

    Long loginWithToken(String token);

    String createUser(User details);
}
