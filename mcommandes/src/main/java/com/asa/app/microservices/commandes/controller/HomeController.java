package com.asa.app.microservices.commandes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/echo")
    public boolean echo(){
        return Boolean.TRUE;
    }
}