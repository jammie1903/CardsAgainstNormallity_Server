package com.jamie.cards.service.impl;

import com.jamie.cards.bean.AuthenticationDetails;
import com.jamie.cards.entity.User;
import com.jamie.cards.repository.UserRepository;
import com.jamie.cards.service.TokenService;
import com.jamie.cards.service.UserService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenGenerator;

    @Value("${token.expiry.hours}")
    private int tokenTimeout;

    @Override
    public AuthenticationDetails login(User details) {
        User user = userRepository.findByUsername(details.getUsername());
        if(user != null) {
            if(BCrypt.checkpw(details.getPassword(), user.getPassword())) {
                user.setLoginToken(tokenGenerator.get());
                user.setLastReadDate(new Date());
                userRepository.save(user);
                return new AuthenticationDetails(user.getId(), user.getLoginToken());
            } else {
                throw new SecurityException("Password was not valid");
            }
        } else {
           throw new SecurityException("Username was not valid");
        }
    }

    @Override
    public Long loginWithToken(String token) {
        User user = userRepository.findByLoginToken(token);
        if (user == null) {
            throw new SecurityException("Invalid token");
        }
        if(user.getLastReadDate().before(DateUtils.addHours(new Date(), -tokenTimeout))) {
            throw new SecurityException("Token has timed out");
        }
        return user.getId();
    }

    @Override
    public String createUser(User details) {
        if(userRepository.findByUsername(details.getUsername()) != null) {
            throw new UnsupportedOperationException("User " + details.getUsername() + " already exists");
        }
        details.setPassword(BCrypt.hashpw(details.getUsername(), BCrypt.gensalt()));
        details.setLoginToken(tokenGenerator.get());
        details.setLastReadDate(new Date());
        userRepository.save(details);
        return details.getLoginToken();
    }
}