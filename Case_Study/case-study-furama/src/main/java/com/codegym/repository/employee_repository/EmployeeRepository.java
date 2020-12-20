package com.codegym.repository.employee_repository;

import com.codegym.entities.customer_entity.Customer;
import com.codegym.entities.employee_entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findAllByEmployeeNameContaining(Pageable pageable, String keyword);
}
