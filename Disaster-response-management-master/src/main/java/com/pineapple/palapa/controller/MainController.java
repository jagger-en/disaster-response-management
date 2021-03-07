package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
public class MainController {

    @GetMapping("")
    public String renderMainPage(Model model) {
        model.addAttribute("pageToRender", "/main");
        return "index";
    }
}