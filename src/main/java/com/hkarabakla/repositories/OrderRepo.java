package com.hkarabakla.repositories;

import com.hkarabakla.entities.Orders;
import com.hkarabakla.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface OrderRepo extends CrudRepository<Orders, Integer> {
    List<Orders> findAllByUser_Name(String name);
}
