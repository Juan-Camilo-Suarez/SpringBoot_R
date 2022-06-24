package ru.itis.examweb.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.itis.examweb.controllers.dto.RegisterUserDto;
import ru.itis.examweb.models.User;

import java.util.List;

public interface UserService {
    User registerNewUser(RegisterUserDto registerUserDto)throws JsonProcessingException;
    List<User> findByNombre(String name);
}
