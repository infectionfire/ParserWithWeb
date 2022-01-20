package com.example.parserwithweb.controller;

import com.example.parserwithweb.entity.Data;
import com.example.parserwithweb.exception.ExceptionHandlerController;
import com.example.parserwithweb.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

import static com.example.parserwithweb.modules.VI.config.StructureCardBuilder.BuildDescription;

@Controller
public class DataController extends ExceptionHandlerController {

    private static final Logger LOG = LoggerFactory.getLogger(DataController.class);

    @Autowired
    @Qualifier("dataService")
    private DataService dataService;

    @GetMapping(value="/")
    public String greetingForm(Model model) {
        model.addAttribute("search", new Data());
        return "greeting";
    }

    @PostMapping(value="/search")
    public String greetingSubmit(@ModelAttribute Data data, Model model) throws IOException {
        data.setDescription(BuildDescription(data.getUrl()));
        dataService.persist(data);
        data.setUrl("");
        model.addAttribute("search", data);
        return "result";
    }


}