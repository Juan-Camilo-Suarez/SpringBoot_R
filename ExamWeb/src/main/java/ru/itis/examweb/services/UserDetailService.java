package ru.itis.examweb.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.examweb.controllers.dto.RegisterUserDto;
import ru.itis.examweb.models.User;
import ru.itis.examweb.repositories.UserRepository;

import java.util.List;

@Service
public class UserDetailService implements UserService{
    @Autowired
    UserRepository userRepository;

    public User user = new User();

    @Override
    public User registerNewUser(RegisterUserDto registerUserDto) throws JsonProcessingException {
        user.setName(registerUserDto.getName());
        user.setAge(registerUserDto.getAge());
        user.setEmail(registerUserDto.getEmail());
        user.setPassword(registerUserDto.getPassword());
        userRepository.save(user);

        return user;
    }


    public User getuser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }
}
