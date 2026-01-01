package com.otabek.day13;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hello")
    public String sayHello(){
        return "\uD83D\uDC4B Hello Otabek! Welcome to Spring Boot 2026!";
    }

    @GetMapping("/user")
    public User getUser(){
        return new User("Otabek", 22);
    }

    @GetMapping("/hello/{name}")
    public String sayHelloByName(@PathVariable String name){
        return "\uD83D\uDC4B Hello "+name+"! Welcome to Spring Boot 2026!";
    }

    @GetMapping("/sum")
    public int calculateSum(@RequestParam int a,@RequestParam int b){
        return a+b;
    }

}
