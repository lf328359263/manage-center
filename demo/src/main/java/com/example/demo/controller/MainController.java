package com.example.demo.controller;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> listUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
