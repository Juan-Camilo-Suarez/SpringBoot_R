package ru.itis.examweb.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itis.examweb.models.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select m from User m where UPPER(name) like '%'|| :name ||'%' ")
    List<User> findByNombre(@Param("name") String name);

    User findByName(String username);
}
