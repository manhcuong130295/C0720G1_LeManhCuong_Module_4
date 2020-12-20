package com.codegym.service.customer_service;

import com.codegym.entities.customer_entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    Customer findById(int id);


    void remove(int id);

    Page<Customer> findAllByCustomerNameContaining(Pageable pageable,String keyword);

}
