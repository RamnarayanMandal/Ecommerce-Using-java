package com.telusko.Ecommcess.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greet(){
        System.out.println("Hello World");
        return "welcome to Ecommcess web application";
    }

    @RequestMapping("/about")
    public String about(){
        return " your know me about me";

    }
}
