package com.example.forum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// endpoints
public class ForumController {
@GetMapping("/hi")
    public String sayHi(){
    return "Hi, world!!";
}
}
