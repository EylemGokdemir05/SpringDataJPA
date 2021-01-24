package com.hkarabakla.services;

import com.hkarabakla.entities.Book;
import com.hkarabakla.entities.Category;
import com.hkarabakla.repositories.BookRepo;
import com.hkarabakla.repositories.CategoryRepo;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.UUID;

@Component
public class CategoryService {

    private final CategoryRepo categoryRepo;
    private final BookRepo bookRepo;

    public CategoryService(CategoryRepo categoryRepo, BookRepo bookRepo) {
        this.categoryRepo = categoryRepo;
        this.bookRepo = bookRepo;
    }

    public void categoryOperations() {

        Book b1 = new Book();
        b1.setIsbn(UUID.randomUUID().toString());
        b1.setName("Spring in Action");

        Category c1 = new Category();
        c1.setName("Computer Science");
        c1.setBooks(Collections.singletonList(b1));

        b1.setCategory(c1);

        categoryRepo.save(c1);
        bookRepo.save(b1);

        System.out.println(c1);
    }
}
