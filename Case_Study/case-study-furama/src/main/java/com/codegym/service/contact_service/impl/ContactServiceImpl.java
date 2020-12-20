package com.codegym.service.contact_service.impl;

import com.codegym.entities.contact_entity.Contact;
import com.codegym.entities.customer_entity.Customer;
import com.codegym.entities.employee_entity.Employee;
import com.codegym.entities.service_entity.Service;
import com.codegym.repository.contact_repository.ContactRepository;
import com.codegym.repository.customer_repository.CustomerRepository;
import com.codegym.repository.employee_repository.EmployeeRepository;
import com.codegym.repository.service_repository.ServiceRepository;
import com.codegym.service.contact_service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<Contact> findAll() {
        return this.contactRepository.findAll();
    }

    @Override
    public void save(Contact contact) {
       this.contactRepository.save(contact);

    }

    @Override
    public List<Customer> listCustomer() {
        return this.customerRepository.findAll();
    }

    @Override
    public List<Employee> listEmployee() {
        return this.employeeRepository.findAll();
    }

    @Override
    public List<Service> listService() {
        return this.serviceRepository.findAll();
    }
}
