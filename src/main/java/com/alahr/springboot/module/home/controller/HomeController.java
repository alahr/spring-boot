package com.alahr.springboot.module.home.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping(value = "/")
    public String home(){
        return "Welcome to the project of Spring Boot!";
    }
}
