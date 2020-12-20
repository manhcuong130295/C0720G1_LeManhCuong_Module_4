package com.codegym.service.contact_service;

import com.codegym.entities.contact_entity.AttachService;
import com.codegym.entities.contact_entity.Contact;
import com.codegym.entities.contact_entity.ContactDetail;

import java.util.List;

public interface ContactDetailService {
    List<ContactDetail> findAll();
    void save(ContactDetail contactDetail);
    List<Contact> listContact();
    List<AttachService> listAttachService();
}
