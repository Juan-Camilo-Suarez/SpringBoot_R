package ru.itis.examweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.examweb.controllers.dto.RegisterUserDto;
import ru.itis.examweb.services.UserDetailService;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    private UserDetailService userDetailService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        RegisterUserDto userDto = new RegisterUserDto();
        model.addAttribute("user", userDto);
        return "register";
    }
    //register
    @PostMapping("/register")
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid RegisterUserDto userDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPassword);
        try {
            userDetailService.registerNewUser(userDto);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(("message An account for that username/email already exists."));
            return null;
        }

        return new ModelAndView("loginform", "user", userDto);
    }
}
