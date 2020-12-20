package com.codegym.service.contact_service.impl;

import com.codegym.entities.contact_entity.AttachService;
import com.codegym.entities.contact_entity.Contact;
import com.codegym.entities.contact_entity.ContactDetail;
import com.codegym.entities.customer_entity.Customer;
import com.codegym.entities.employee_entity.Employee;
import com.codegym.entities.service_entity.Service;
import com.codegym.repository.contact_repository.AttachServiceRepository;
import com.codegym.repository.contact_repository.ContactDetailRepository;
import com.codegym.repository.contact_repository.ContactRepository;
import com.codegym.service.contact_service.ContactDetailService;
import com.codegym.service.contact_service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class ContactDetailServiceImpl implements ContactDetailService {
    @Autowired
    ContactDetailRepository contactDetailRepository;
    @Autowired
    AttachServiceRepository attachServiceRepository;
    @Autowired
    ContactRepository contactRepository;

    @Override
    public List<ContactDetail> findAll() {
        return this.contactDetailRepository.findAll();
    }

    @Override
    public void save(ContactDetail contactDetail) {
       this.contactDetailRepository.save(contactDetail);
    }

    @Override
    public List<Contact> listContact() {
        return this.contactRepository.findAll();
    }

    @Override
    public List<AttachService> listAttachService() {
        return this.attachServiceRepository.findAll();
    }
}
