package com.hkarabakla.services;

import com.hkarabakla.entities.Author;
import com.hkarabakla.entities.Book;
import com.hkarabakla.entities.Category;
import com.hkarabakla.repositories.AuthorRepo;
import com.hkarabakla.repositories.BookRepo;
import com.hkarabakla.repositories.CategoryRepo;
import com.hkarabakla.repositories.OrderRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class BookService {
    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;
    private final CategoryRepo categoryRepo;
    private final OrderRepo orderRepo;

    public BookService(BookRepo bookRepo, AuthorRepo authorRepo, CategoryRepo categoryRepo, OrderRepo orderRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.categoryRepo = categoryRepo;
        this.orderRepo = orderRepo;
    }

    public void bookOperations(){
        Book book=new Book();
        book.setIsbn(UUID.randomUUID().toString());
        book.setName("Clean Code");
        book.setDescription("I love Clean Code :)");
        book.setPublishedDate(LocalDate.of(1994,10,07));
        book.setAddedDate(LocalDate.of(1995,05,31));
        book.setCurrency("TL");
        book.setImageUrl("https://spring.io/projects");
        Author author=new Author();
        author.setName("Anonymous");
        author.setAuthor_books(Arrays.asList(book));
        Category category=categoryRepo.findByName("Computer Science");
        List<Book> bookList=category.getBooks();
        bookList.add(book);
        category.setBooks(bookList);

        book.setCategory(category);

        authorRepo.save(author);
        bookRepo.save(book);
        categoryRepo.save(category);

        System.out.println(authorRepo.findByName("Anonymous"));
        System.out.println(categoryRepo.findByName("Computer Science"));
        System.out.println(bookRepo.findByName("Clean Code"));
    }
}
