package com.c0720g1.manhcuong.controller;

import com.c0720g1.manhcuong.service.CaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaculatorController {
    @Autowired
    CaculatorService caculatorService;

    @GetMapping("")
    public String getHome() {
        return "index";
    }

    @GetMapping("/caculator")
    public String caculator(@RequestParam Integer num1, @RequestParam Integer num2, @RequestParam String operator, Model model) throws ArithmeticException {
        try {
            model.addAttribute("num1", num1);
            model.addAttribute("num2", num2);
            model.addAttribute("operator", operator);
            model.addAttribute("result", caculatorService.caculating(num1, num2, operator));

        } catch (ArithmeticException e) {
            String error = e.getMessage();
            model.addAttribute("result",error);
        }
        return "result";
    }
}
