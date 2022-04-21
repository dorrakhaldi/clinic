package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rh")
public class UserController {

    @GetMapping
    public String Works(){
        return "MicroService RH test is running . . . ";
    }

}
