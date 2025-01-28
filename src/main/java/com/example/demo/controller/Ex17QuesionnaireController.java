package com.example.demo.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.Questionnaire;
import com.example.demo.form.Ex17QuestionnaireForm;

@Controller
@RequestMapping("/ex17")
public class Ex17QuesionnaireController {

    @ModelAttribute
    public Ex17QuestionnaireForm setUpForm() {
        return new Ex17QuestionnaireForm();
    }

    @RequestMapping("")
    public String index(Model model) {
        Map<Integer, String> hobbyMap = new LinkedHashMap<>();
        hobbyMap.put(1, "野球");
        hobbyMap.put(2, "サッカー");
        hobbyMap.put(3, "テニス");
        model.addAttribute("hobbyMap", hobbyMap);
        Map<Integer, String> langMap = new LinkedHashMap<>();
        langMap.put(1, "Java");
        langMap.put(2, "JavaScript");
        langMap.put(3, "PHP");
        langMap.put(4, "Python");
        model.addAttribute("langMap", langMap);
        return "ex17/input";
    }

    @RequestMapping("/create")
    public String create(
        @Validated Ex17QuestionnaireForm form
        , BindingResult result
        , RedirectAttributes redirectAttributes
        , Model model
    ) {
        if (result.hasErrors()) {
            return index(model);
        }

        Questionnaire questionnaire = new Questionnaire();
        BeanUtils.copyProperties(form, questionnaire);
        questionnaire.setHobbyList(convertHobbyList(form.getHobbyList()));
        switch (form.getLang()) {
            case 1 -> questionnaire.setLang("Java");
            case 2 -> questionnaire.setLang("JavaScript");
            case 3 -> questionnaire.setLang("PHP");
            case 4 -> questionnaire.setLang("Python");
        }

        redirectAttributes.addFlashAttribute("questionnaire", questionnaire);
        return "redirect:/ex17/toresult";
    }

    @RequestMapping("/toresult")
    public String toResult() {
        return "ex17/result";
    }

    private List<String> convertHobbyList(List<Integer> hobbyList) {
        List<String> strHobbyList = new ArrayList<>();
        for (int code : hobbyList) {
            switch (code) {
                case 1 -> strHobbyList.add("野球");
                case 2 -> strHobbyList.add("サッカー");
                case 3 -> strHobbyList.add("テニス");
                case 4 -> strHobbyList.add("卓球");
            }
        }
        return strHobbyList;
    }
}