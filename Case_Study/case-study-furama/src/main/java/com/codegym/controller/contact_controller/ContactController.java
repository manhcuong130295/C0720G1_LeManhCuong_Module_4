package com.codegym.controller.contact_controller;

import com.codegym.entities.contact_entity.Contact;
import com.codegym.entities.customer_entity.Customer;
import com.codegym.entities.customer_entity.CustomerType;
import com.codegym.entities.employee_entity.Employee;
import com.codegym.entities.service_entity.Service;
import com.codegym.service.contact_service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("contact")
public class ContactController {
    @Autowired
    ContactService contactService;

    @ModelAttribute("customer")
    public Iterable<Customer> customers() {
        return this.contactService.listCustomer();
    }

    @ModelAttribute("employee")
    public Iterable<Employee> employees() {
        return this.contactService.listEmployee();
    }

    @ModelAttribute("service")
    public Iterable<Service> services() {
        return this.contactService.listService();
    }
    @GetMapping("/list-contact")
    public String listContact(Model model){
        model.addAttribute("listContact", this.contactService.findAll());
        return "contact/list";
    }
    @GetMapping("/create-contact")
    public String formCreate(Model model){
        model.addAttribute("contact",new Contact());
        return "contact/create";
    }
    @PostMapping("/save")
    public String saveContact(@ModelAttribute Contact contact){
        this.contactService.save(contact);
        return "redirect:/contact/list-contact";
    }
}
