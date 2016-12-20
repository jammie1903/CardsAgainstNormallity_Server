package com.jamie.cards.service;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.SecureRandom;

public interface TokenService {
  String get();
}