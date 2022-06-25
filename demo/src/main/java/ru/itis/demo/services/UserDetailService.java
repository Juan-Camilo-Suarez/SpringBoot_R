package ru.itis.demo.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.controllers.dto.RegisterUserDto;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UserRepository;


@Service
public class UserDetailService implements UserService {
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
