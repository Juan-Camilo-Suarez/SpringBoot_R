package ru.itis.examweb.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.examweb.controllers.dto.RegisterUserDto;
import ru.itis.examweb.services.UserDetailService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    UserDetailService userDetailsService;

    @GetMapping("/login")
    public String loginPage(Model model) throws JsonProcessingException {
        System.out.println(model);

        return "loginform";

    }
    @PostMapping("/usercheck")
    public String loginForm(HttpServletRequest request, Model model, RegisterUserDto userDto) throws JsonProcessingException {
        System.out.println(userDto.getName() + "--------------");
        try {
            request.login(userDto.getName(), userDto.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "/";
    }
}
