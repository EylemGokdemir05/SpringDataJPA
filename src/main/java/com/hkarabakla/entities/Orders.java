package com.hkarabakla.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Orders {

    @Id
    @GeneratedValue
    private int id;

    private LocalDate createdDate;

    private double total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_orders",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> order_books;

    public List<Book> getOrder_books() {
        return order_books;
    }

    public void setOrder_books(List<Book> order_books) {
        this.order_books = order_books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", total=" + total +
                ", user=" + user +
                ", order_books=" + order_books +
                '}';
    }
}
