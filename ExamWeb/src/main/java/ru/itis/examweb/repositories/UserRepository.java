package ru.itis.examweb.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itis.examweb.models.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

   List<User> findAll();

    User findByName(String username);

}
