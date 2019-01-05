package com.asa.app.microservices.produits.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/echo")
    public boolean echo(){ return Boolean.TRUE;}
}
