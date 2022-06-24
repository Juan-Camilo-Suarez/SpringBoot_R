package ru.itis.examweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.examweb.models.User;
import ru.itis.examweb.services.UserDetailService;

import java.util.List;

@RestController
public class UsersRestController {
    @Autowired
    UserDetailService userDetailsService;

    @RequestMapping("/merch")
    public List<User> getAllMerch(@RequestParam("name") String name) {
        return userDetailsService.findByNombre(name);
    }
}
