package com.hkarabakla.services;

import com.hkarabakla.entities.Address;
import com.hkarabakla.entities.Orders;
import com.hkarabakla.entities.User;
import com.hkarabakla.repositories.OrderRepo;
import com.hkarabakla.repositories.UserRepo;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public void userOperations() {
        User u = new User();
        u.setName("user");

        Address address = new Address();
        address.setStreet("Gazi sokak");
        address.setNumber("7");
        address.setCity("Istanbul");
        u.setAddress(address);

        repo.save(u);

        System.out.println(repo.findAllByNameContainingIgnoreCase("se"));
    }
}
