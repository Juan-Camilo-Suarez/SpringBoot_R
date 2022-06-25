package ru.itis.examweb.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.examweb.repositories.UserRepository;

import java.util.List;

@RestController
public class User {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/getusers")
    public List<ru.itis.examweb.models.User> getUsers(){
        return userRepository.findAll();
    }

}
