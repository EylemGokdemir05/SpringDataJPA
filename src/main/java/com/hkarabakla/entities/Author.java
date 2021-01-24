package com.hkarabakla.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "authors_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> author_books;

    public List<Book> getAuthor_books() {
        return author_books;
    }

    public void setAuthor_books(List<Book> author_books) {
        this.author_books = author_books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author_books=" + author_books +
                '}';
    }
}
