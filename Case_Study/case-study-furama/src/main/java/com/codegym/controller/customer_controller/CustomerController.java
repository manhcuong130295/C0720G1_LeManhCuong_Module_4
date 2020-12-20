package com.codegym.controller.customer_controller;

import com.codegym.entities.customer_entity.Customer;
import com.codegym.entities.customer_entity.CustomerType;
import com.codegym.service.customer_service.CustomerService;
import com.codegym.service.customer_service.CustomerTypeService;
import com.codegym.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @ModelAttribute("customerType")
    public Iterable<CustomerType> provinces() {
        return customerTypeService.findAll();
    }

    @GetMapping("/list")
    public String listCustomer(Model model, @PageableDefault(size = 5) Pageable pageable,
                               @RequestParam Optional<String> keyword) {
        String keyWordAfterSearch = "";

        if (!keyword.isPresent()) {
            model.addAttribute("listCustomer", this.customerService.findAll(pageable));
        } else {
            keyWordAfterSearch = keyword.get();
            model.addAttribute("listCustomer", this.customerService.findAllByCustomerNameContaining(pageable, keyWordAfterSearch));
        }
        model.addAttribute("keywordAfterCheck", keyWordAfterSearch);
        return "customer/listCustomer";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create_customer";
    }

    @PostMapping("/save")
    public String saveCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer/create_customer";
        }
        this.customerService.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/{id}/edit")
    public String formEdit(@PathVariable int id, Model model) {
        model.addAttribute("customer", this.customerService.findById(id));
        return "customer/editCustomer";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String id) {
        this.customerService.remove(Integer.parseInt(id));
        return "redirect:/customer/list";
    }

    @GetMapping("/{id}/detail")
    public String detailCus(Model model, @PathVariable int id) {
        model.addAttribute("customer", this.customerService.findById(id));
        return "customer/detail";
    }
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "home";
    }
}
