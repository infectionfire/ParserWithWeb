package com.example.parserwithweb.controller;

import com.example.parserwithweb.entity.Data;
import com.example.parserwithweb.exception.ExceptionHandlerController;
import com.example.parserwithweb.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.Map;

import static com.example.parserwithweb.modules.VI.config.StructureCardBuilder.BuildDescriptionForOneCard;

@Controller
public class DataController extends ExceptionHandlerController {

    @Autowired
    @Qualifier("dataService")
    private DataService dataService;

    @GetMapping(value="/")
    public String greetingForm(Model model) {
        model.addAttribute("search", new Data());
        return "greeting";
    }

    @PostMapping(value="/search")
    public String greetingSubmit(@ModelAttribute Data data
            , BindingResult bindingResult
            , Model model) throws IOException {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("data", data);
        return "result";
        }
        data.setDescription(BuildDescriptionForOneCard(data.getUrl()));
        dataService.persist(data);
        data.setUrl("");//костыль для отображения thymeleaf пустого поля ввода, не собираюсь доделывать фронт
        model.addAttribute("search", data);
        return "result";
    }


}