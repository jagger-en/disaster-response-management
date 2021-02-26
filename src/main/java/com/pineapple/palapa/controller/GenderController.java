package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pineapple.palapa.model.Gender;
import com.pineapple.palapa.service.GenderService;

import java.util.List;

@Controller
@RequestMapping("/genders") 
public class GenderController {

    private final GenderService genderService;

    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping("")
    public String getAllGenders(Gender gender, Model model) {
        List<Gender> genders = genderService.findAllGenders();
        model.addAttribute("genders", genders);
        model.addAttribute("pageToRender", "/genders/createGenders");
        return "base";
    }

    @PostMapping("/add")
    public String addGender(Gender gender, Model model) {
        genderService.addGender(gender);
        return "redirect:/genders";
    }

    @GetMapping("/delete/{id}")
    public String deleteGender(@PathVariable("id") Long id) {
        genderService.deleteGender(id);
        return "redirect:/genders";
    }
}