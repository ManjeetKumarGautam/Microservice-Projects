package com.ecommerce.user.UserService.controller;

import com.ecommerce.user.UserService.model.User;
import com.ecommerce.user.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String createUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId){
        return userService.getUser(userId);

    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

}
