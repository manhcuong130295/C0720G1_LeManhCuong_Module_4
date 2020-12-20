package com.codegym.controller.contact_controller;

import com.codegym.entities.contact_entity.AttachService;
import com.codegym.entities.contact_entity.Contact;
import com.codegym.entities.contact_entity.ContactDetail;
import com.codegym.entities.customer_entity.Customer;
import com.codegym.service.contact_service.ContactDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("contact-detail")
public class ContactDetailController {
    @Autowired
    ContactDetailService contactDetailService;

    @ModelAttribute("contact")
    public Iterable<Contact> contacts() {
        return this.contactDetailService.listContact();
    }

    @ModelAttribute("attachService")
    public Iterable<AttachService> attachServices() {
        return this.contactDetailService.listAttachService();
    }

    @GetMapping("/create")
    public String createContactDetail(Model model){
        model.addAttribute("contactDetail",new ContactDetail());
        return "contact/createContactDetail";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute ContactDetail contactDetail){
        this.contactDetailService.save(contactDetail);
        return "redirect:/contact/list-contact";
    }
}
