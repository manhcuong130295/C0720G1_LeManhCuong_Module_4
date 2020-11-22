package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ConversionService;

@Controller
public class CurrencyConversionController {
    @Qualifier("convertUsdToVndService")
    @Autowired
    ConversionService conversionService;

    @PostMapping({"/convert"})
    public String covert(@RequestParam String usd, Model model){
        int result=conversionService.convert(Integer.parseInt(usd));
        model.addAttribute("resultFinal",result);
        return "result";
    }
    @GetMapping("")
    public String getHome(){
        return "form";
    }
}
