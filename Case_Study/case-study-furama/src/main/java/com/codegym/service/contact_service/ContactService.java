package com.codegym.service.contact_service;

import com.codegym.entities.contact_entity.Contact;
import com.codegym.entities.customer_entity.Customer;
import com.codegym.entities.employee_entity.Employee;
import com.codegym.entities.service_entity.Service;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();

    void save(Contact contact);

    List<Customer> listCustomer();

    List<Employee> listEmployee();

    List<Service> listService();
}
