package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    //    @RequestMapping(value={"", "/greeting"},method = RequestMethod.GET)
//    yêu cầu 1:
//    @GetMapping({"", "/greeting"})
//    public String greeting() {
//        return "index";
//    }
//    yêu cầu 2:
   @GetMapping("/greeting")
    public String greeting(@RequestParam String name, Model model) {
        model.addAttribute("name",name);
        return "index";
    }
}
