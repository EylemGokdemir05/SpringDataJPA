package com.eylem.repositories;

import com.eylem.entities.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface OrderRepo extends CrudRepository<Orders, Integer> {
    List<Orders> findAllByUser_Name(String name);
}
