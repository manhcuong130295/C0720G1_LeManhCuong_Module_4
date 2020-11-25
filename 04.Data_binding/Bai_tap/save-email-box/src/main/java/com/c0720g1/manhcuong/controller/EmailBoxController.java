package com.c0720g1.manhcuong.controller;

import com.c0720g1.manhcuong.model.EmailBox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailBoxController {
    public static List<String> listEnglish = new ArrayList<>();
    public static List<Integer> page_size=new ArrayList<>();

    static {
        listEnglish.add("English");
        listEnglish.add("Vietnamese");
        listEnglish.add("Japan");
        listEnglish.add("Chinese");
    }

    static {
        page_size.add(5);
        page_size.add(10);
        page_size.add(15);
        page_size.add(25);
        page_size.add(50);
        page_size.add(100);
    }
    @GetMapping("/create")
    public String createNew(Model model, EmailBox emailBox){
        List<String> listLanguage=listEnglish;
        List<Integer> listPageSize=page_size;
        model.addAttribute("emailBox",new EmailBox());
        model.addAttribute("listEnglish",listEnglish);
        model.addAttribute("page_size",page_size);
        return "create";
    }
}
