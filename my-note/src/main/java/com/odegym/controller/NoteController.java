package com.odegym.controller;

import com.odegym.entity.Note;
import com.odegym.entity.NoteType;
import com.odegym.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class NoteController {
    @Autowired
    NoteService noteService;

    @ModelAttribute("noteTypes")
    public Iterable<NoteType> noteTypes() {
        return noteService.findAllNoteType();
    }

    @GetMapping("/")
    public String listNote(Model model, @PageableDefault(size = 5) Pageable pageable,
                           @RequestParam Optional<String> title) {
        String keyWordAfterSearch = "";

        if (!title.isPresent()) {
            model.addAttribute("noteList", this.noteService.findAll(pageable));
        } else {
            keyWordAfterSearch = title.get();
            model.addAttribute("noteList", this.noteService.findAllByTitleContaining(pageable, keyWordAfterSearch));
        }

        model.addAttribute("keywordAfterCheck", keyWordAfterSearch);
        return "listNote";
    }
    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("note",new Note());
        return "create";
    }
    @PostMapping("/save")
    public String saveNote(@ModelAttribute Note note, RedirectAttributes redirectAttributes){
        this.noteService.save(note);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String formEdit(@PathVariable int id, Model model){
        model.addAttribute("note",this.noteService.findById(id));
        return "edit";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam String id){
        this.noteService.deleteById(Integer.parseInt(id));
        return "redirect:/";
    }
    @GetMapping("/{id}/detail")
    public String detail(@PathVariable int id, Model model){
        model.addAttribute("note",this.noteService.findById(id));
        return "detail";
    }
    @GetMapping("/{id}/type/search")
    public String categorySearch(@PathVariable int id, @PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("blogList", this.noteService.findAllByNoteTypeId(pageable, id));
        return "redirect:/";
    }
}
