package com.example.parserwithweb.controller;

import com.example.parserwithweb.model.Search;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    @GetMapping(value="/")
    public String greetingForm(Model model) {
        model.addAttribute("search", new Search());
        return "greeting";
    }

    @PostMapping(value="/search")
    public String greetingSubmit(@ModelAttribute Search search, Model model) {
        model.addAttribute("search", search);
        return "result";
    }

}