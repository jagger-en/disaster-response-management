package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/dashboard")


public class DashboardController {

    public DashboardController() {

    }

    @GetMapping("")
    public String getAllCitys(Model model) {
        model.addAttribute("pageToRender", "/dashboard/index");
        return "index";
    }
}
