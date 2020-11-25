package com.c0720g1.manhcuong.controller;

import com.c0720g1.manhcuong.model.EmailBox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailBoxController {
    public static List<String> listLanguages = new ArrayList<>();
    public static List<Integer> page_size=new ArrayList<>();

    static {
        listLanguages.add("English");
        listLanguages.add("Vietnamese");
        listLanguages.add("Japan");
        listLanguages.add("Chinese");
    }

    static {
        page_size.add(5);
        page_size.add(10);
        page_size.add(15);
        page_size.add(25);
        page_size.add(50);
        page_size.add(100);
    }
    @GetMapping({"","/create"})
    public String createNew(Model model, EmailBox emailBox){
        List<String> listLanguage=listLanguages;
        List<Integer> listPageSize=page_size;
        model.addAttribute("emailBox",new EmailBox());
        model.addAttribute("listLanguages",listLanguages);
        model.addAttribute("page_size",page_size);
        return "create";
    }

    @PostMapping("/detail")
    public String detail(@ModelAttribute EmailBox emailBox,Model model){
           model.addAttribute("emailBox",emailBox);
           return "detail";
    }
}
