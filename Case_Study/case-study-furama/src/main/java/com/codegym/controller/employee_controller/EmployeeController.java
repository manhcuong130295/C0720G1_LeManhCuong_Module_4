package com.codegym.controller.employee_controller;

import com.codegym.entities.employee_entity.Division;
import com.codegym.entities.employee_entity.EducationDegree;
import com.codegym.entities.employee_entity.Employee;
import com.codegym.entities.employee_entity.Position;
import com.codegym.entities.user_entity.AppUser;
import com.codegym.service.employee_service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @ModelAttribute("position")
    public Iterable<Position> positions() {
        return employeeService.listPosition();
    }

    @ModelAttribute("division")
    public Iterable<Division> divisions() {
        return employeeService.listDivision();
    }

    @ModelAttribute("education_degree")
    public Iterable<EducationDegree> educationDegrees() {
        return employeeService.listEducationDegree();
    }
    @ModelAttribute("user")
    public Iterable<AppUser> users() {
        return employeeService.listUser();
    }

    @GetMapping("/list-employee")
    public String listCustomer(Model model, @PageableDefault(size = 5) Pageable pageable,
                               @RequestParam Optional<String> keyword) {
        String keyWordAfterSearch = "";

        if (!keyword.isPresent()) {
            model.addAttribute("listEmployee", this.employeeService.findAll(pageable));
        } else {
            keyWordAfterSearch = keyword.get();
            model.addAttribute("listEmployee", this.employeeService.findAllByEmployeeNameContaining(pageable, keyWordAfterSearch));
        }

        model.addAttribute("keywordAfterCheck", keyWordAfterSearch);
        return "employee/list-employee";
    }
    @GetMapping("/create-employee")
    public String formCreate(Model model){
        model.addAttribute("employee",new Employee());
        return "employee/create";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee){
        this.employeeService.save(employee);
        return "redirect:/employee/list-employee";
    }
    @GetMapping("/{id}/edit")
    public String formEdit(@PathVariable int id, Model model) {
        model.addAttribute("employee", this.employeeService.findById(id));
        return "employee/edit";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam String id){
        this.employeeService.remove(Integer.parseInt(id));
        return "redirect:/employee/list-employee";
    }
    @GetMapping("/{id}/detail")
    public String detailCus(Model model,@PathVariable int id){
        model.addAttribute("employee",this.employeeService.findById(id));
        return "employee/detail";
    }
}
