package com.ecommerce.user.UserService.service;

import com.ecommerce.user.UserService.model.User;
import com.ecommerce.user.UserService.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepo;

    public String addUser(User user){
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        userRepo.save(user);
        return "User sucessfully added.";
    }

    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public User getUser(String userId){
        return userRepo.findById(userId).get();
    }
}
