package com.hkarabakla.repositories;

import com.hkarabakla.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {
    User findByName(String name);
    List<User> findAllByNameContainingIgnoreCase(String name);
}
