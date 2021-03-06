package ru.itis.examweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.examweb.models.User;
import ru.itis.examweb.services.UserDetailService;

@Controller
public class RootController {
     @Autowired
    UserDetailService userDetailService;

    @GetMapping("/")
    public String getIndex(Model model) {
        User user = userDetailService.getuser();
        model.addAttribute("user",user);

        return "root";
    }
}
