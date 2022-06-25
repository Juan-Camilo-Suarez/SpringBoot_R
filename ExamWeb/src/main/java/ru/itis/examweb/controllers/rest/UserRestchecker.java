package ru.itis.examweb.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.examweb.models.User;
import ru.itis.examweb.repositories.UserRepository;

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
