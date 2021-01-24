package com.hkarabakla.repositories;

import com.hkarabakla.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author,Integer> {
    Author findByName(String name);
}
