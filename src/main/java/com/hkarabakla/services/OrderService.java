package com.hkarabakla.services;

import com.hkarabakla.entities.Orders;
import com.hkarabakla.repositories.BookRepo;
import com.hkarabakla.repositories.OrderRepo;
import com.hkarabakla.repositories.UserRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class OrderService {

    private final OrderRepo repo;
    private final BookRepo bookRepo;
    private final UserRepo userRepo;

    public OrderService(OrderRepo repo, BookRepo bookRepo, UserRepo userRepo) {
        this.repo = repo;
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }

    public void orderOperations(){
        Orders orders=new Orders();
        orders.setUser(userRepo.findByName("user"));
        orders.setCreatedDate(LocalDate.now());
        orders.setTotal(bookRepo.findByName("Clean Code").getPrice());
        orders.setOrder_books(Arrays.asList(bookRepo.findByName("Clean Code")));

        repo.save(orders);
        System.out.println(orders);
        System.out.println(repo.findAllByUser_Name("user"));
        System.out.println(bookRepo.findByName("Clean Code"));
    }
}
