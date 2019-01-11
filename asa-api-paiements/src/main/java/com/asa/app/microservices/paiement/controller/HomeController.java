package com.asa.app.microservices.paiement.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/echo", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean echo(){
        return Boolean.TRUE;
    }
}
