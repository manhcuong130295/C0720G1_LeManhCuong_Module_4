package controllers;

import models.Dictionary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.SimpleDictionary;
import services.SimpleDictionaryImpl;

import java.util.List;

@Controller
public class SimpleDictionaryController {
    private SimpleDictionary dictionaryService = new SimpleDictionaryImpl();

    @GetMapping("")
    public String formSearch() {
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam String searchWord, Model model) {
        List<Dictionary> dictionaryList = dictionaryService.getAllList();
        for (int i = 0; i < dictionaryList.size(); i++) {
            if (searchWord.equalsIgnoreCase(dictionaryList.get(i).getEng())) {

                model.addAttribute("result",dictionaryList.get(i).getVie());
                model.addAttribute("searhWord",searchWord);
                return "result";
            }
        }
        return "result";
    }
}
