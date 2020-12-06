package com.codegym.controller;

import com.codegym.entity.Book;
import com.codegym.service.BillService;
import com.codegym.service.BookService;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/book")
@Controller
public class BookController {
    @Autowired
    StudentService studentService;
    @Autowired
    private BillService billService;
    @Autowired
    private BookService bookService;
    @GetMapping("")
    public String listBook(Model model){
        model.addAttribute("bookList",this.bookService.findAll());
        return "listBook";
    }
    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("book",new Book());
        return "createBook";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Book book){
        this.bookService.save(book);
        return "redirect:/book/";
    }
    @GetMapping("/{id}/edit")
    public String formEdit(@PathVariable int id,Model model){
        model.addAttribute("book",this.bookService.findById(id));
        return "editBook";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id){
        this.bookService.remove(id);
        return "redirect:/book/";
    }
    @GetMapping("/{id}/detail")
    public String detailBook(@PathVariable int id,Model model){
        model.addAttribute("book",this.bookService.findById(id));
        return "detailBook";
    }
    @GetMapping("{id}/borrow")
    public String formBorrow(@PathVariable int id){

    }
}
