package com.example.demoweb.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String sayHello(){
        final String str = "hello " + port;
        System.out.println(str);
        return str;
    }
}
