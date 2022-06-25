package ru.itis.demo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.demo.controllers.dto.RegisterUserDto;
import ru.itis.demo.services.UserDetailService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserDetailService userDetailsService;


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        RegisterUserDto userDto = new RegisterUserDto();
        model.addAttribute("user", userDto);
        return "register";
    }
    @PostMapping("/register")
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid RegisterUserDto userDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPassword);
        try {
            userDetailsService.registerNewUser(userDto);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(("message An account for that username/email already exists."));
            return null;
        }

        return new ModelAndView("loginform", "user", userDto);
    }

    @GetMapping("/login")
    public String loginPage(Model model) throws JsonProcessingException {
        System.out.println(model);

        return "loginform";

    }
    @PostMapping("/")
    public String loginForm(HttpServletRequest request, Model model, RegisterUserDto userDto) throws JsonProcessingException {
        System.out.println(userDto.getName() + "--------------");
        try {
            request.login(userDto.getName(), userDto.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "/";
    }
    @GetMapping("/users")
    public String usersPage(){
        return "users";
    }
}
