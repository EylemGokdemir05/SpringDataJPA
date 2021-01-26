package com.eylem.repositories;

import com.eylem.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book,String> {
    Book findByName(String name);
}
