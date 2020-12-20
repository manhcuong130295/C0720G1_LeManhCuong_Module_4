package com.codegym.repository;

import com.codegym.entities.customer_entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAll(Pageable pageable);
//    Page<Customer> findByNameContaining(String keyword, Pageable pageable);
////    Page<Customer> findAllByCustomerNameContainingOrAddressContainingOrEmailContaining(String keyWord,Pageable pageable);
}
