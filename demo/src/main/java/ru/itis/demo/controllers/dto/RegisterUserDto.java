package ru.itis.demo.controllers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {
    private String name;
    private String age;
    private String email;
    private String password;
}
