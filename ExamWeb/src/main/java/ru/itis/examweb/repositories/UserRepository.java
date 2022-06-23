package ru.itis.examweb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.itis.examweb.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String username);
}
