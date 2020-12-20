package com.codegym.controller.customer_controller;

import com.codegym.service.customer_service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomer(Model model,@PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("listCustomer",this.customerService.findAll(pageable));
        return "listCustomer";
    }
//    public String listCustomer(Model model, @PageableDefault(size = 5) Pageable pageable,
//                               @RequestParam Optional<String> keyword) {
//        String keyWordAfterSearch="";
//
//        if (!keyword.isPresent()) {
//            model.addAttribute("listCustomer", this.customerService.findAll(pageable));
//        } else {
//            keyWordAfterSearch = keyword.get();
//            model.addAttribute("listCustomer", this.customerService.findByNameContaining(keyWordAfterSearch, pageable));
//        }
//
//        model.addAttribute("keywordAfterCheck", keyWordAfterSearch);
//        return "listCustomer";
//    }

}
