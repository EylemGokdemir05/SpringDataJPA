package com.hkarabakla.repositories;

import com.hkarabakla.entities.Book;
import com.hkarabakla.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Integer> {
    Category findByName(String name);
}
