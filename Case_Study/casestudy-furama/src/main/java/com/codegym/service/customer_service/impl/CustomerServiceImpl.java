package com.codegym.service.customer_service.impl;

import com.codegym.entities.customer_entity.Customer;
import com.codegym.repository.CustomerRepository;
import com.codegym.service.customer_service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.customerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
      this.customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findByNameContaining(String keyword, Pageable pageable) {
        return null;
    }
}
