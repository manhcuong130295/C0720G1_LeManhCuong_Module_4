package com.codegym.controller;

import com.codegym.service.CategoryService;
import com.codegym.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/category")
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping(" ")
    public String listCategory(Model model){
        model.addAttribute("categoryList",this.categoryService.findAll());
        return "listCategory";
    }

}
