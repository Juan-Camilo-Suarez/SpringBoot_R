package ru.itis.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.demo.models.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

   List<User> findAll();

    User findByName(String username);

}
