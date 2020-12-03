package com.codegym.controller;

import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("")
    public String listBook(Model model){
        model.addAttribute("bookList",this.bookService.findAll());
        return "book/listBook";
    }

}
