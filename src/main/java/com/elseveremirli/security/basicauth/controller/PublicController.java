package com.elseveremirli.security.basicauth.controller;


import com.elseveremirli.security.basicauth.model.User;
import com.elseveremirli.security.basicauth.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/public")
public class PublicController {
    private final  UserService userService;

    public PublicController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> helloWord(){
        return userService.getAll();
    }


    @GetMapping("/{username}")
    public Optional<User> getByUsername(@PathVariable String username){
        return userService.getByUsername(username);
    }
}

