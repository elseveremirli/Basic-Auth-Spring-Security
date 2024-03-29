package com.elseveremirli.security.basicauth.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class PrivateController {
    @GetMapping
    public String helloWord(){
        return "Hello world! from private endpoint";
    }

    @GetMapping("/user")
    public String helloWorldUserPrivate(){
        return "Hello world! from private user";
    }


    @GetMapping("/admin")
    public String helloWorldAdminPrivate(){
        return "Hello world! from private admin";
    }
}