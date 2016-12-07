package com.jamie.cards.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
    @RequestMapping(value = "v1/ping", method = RequestMethod.GET)
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }
}
