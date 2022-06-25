package ru.itis.demo.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UserRepository;


import java.util.List;

@RestController
public class UserRestchecker {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/getusers")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
