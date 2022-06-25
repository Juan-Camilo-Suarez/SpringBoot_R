package ru.itis.demo.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.itis.demo.controllers.dto.RegisterUserDto;
import ru.itis.demo.models.User;

public interface UserService {
    User registerNewUser(RegisterUserDto registerUserDto)throws JsonProcessingException;
}
