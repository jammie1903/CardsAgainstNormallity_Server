package com.jamie.cards.service.impl;

import com.jamie.cards.service.TokenService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public final class TokenServiceImpl implements TokenService {
    private SecureRandom random = new SecureRandom();

    @Override
    public String get() {
        return new BigInteger(130, random).toString(32);
    }
}