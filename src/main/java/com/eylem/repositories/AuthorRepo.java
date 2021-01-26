package com.eylem.repositories;

import com.eylem.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author,Integer> {
    Author findByName(String name);
}
