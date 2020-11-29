package com.codegym.controller;

import com.codegym.entity.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @GetMapping("/")
    public String listBlog(Model model){
        model.addAttribute("blogList",this.blogService.findAll());
        return "listBlog";
    }
    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }
    @PostMapping("/save")
    public String createNewBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        this.blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String formEdit(@PathVariable int id,Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "edit";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id){
        this.blogService.remove(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/detail")
    public String detail(@PathVariable int id, Model model){
        model.addAttribute("blogDetail",this.blogService.findById(id));
        return "detail";
    }
}
