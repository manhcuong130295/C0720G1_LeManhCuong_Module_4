package com.codegym.controller.service_controller;

import com.codegym.entities.service_entity.Service;
import com.codegym.service.service_service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("service")
public class ServiceController {
    @Autowired
    ServiceService serviceService;

    @GetMapping("/list-service")
    public String allService(Model model,@PageableDefault(size = 3) Pageable pageable){
     model.addAttribute("listService",this.serviceService.findAll(pageable));
     return "service/listService";
    }
    @GetMapping("/create-service")
    public String formCreate(Model model){
        model.addAttribute("service",new Service());
        model.addAttribute("serviceType",this.serviceService.findAllServiceType());
        model.addAttribute("rentType",this.serviceService.findAllRenType());
        return "service/create";
    }
    @PostMapping("/save")
    public String saveService(@ModelAttribute Service service){
        this.serviceService.save(service);
        return "redirect:/service/list-service";
    }
}
