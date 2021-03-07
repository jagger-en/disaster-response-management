package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pineapple.palapa.model.TeamFunctionality;
import com.pineapple.palapa.service.TeamFunctionalityService;

import java.util.List;

@Controller
@RequestMapping("/teamFunctionalities") 
public class TeamFunctionalityController {

    private final TeamFunctionalityService teamFunctionalityService;

    public TeamFunctionalityController(TeamFunctionalityService teamFunctionalityService) {
        this.teamFunctionalityService = teamFunctionalityService;
    }

    @GetMapping("")
    public String getAllTeamFunctionalities(TeamFunctionality teamFunctionality, Model model) {
        List<TeamFunctionality> teamFunctionalities = teamFunctionalityService.findAllTeamFunctionalities();
        model.addAttribute("teamFunctionalities", teamFunctionalities);
        model.addAttribute("pageToRender", "/teamFunctionalities/createTeamFunctionalities");
        return "index";
    }

    @PostMapping("/add")
    public String addTeamFunctionality(TeamFunctionality teamFunctionality, Model model) {
        teamFunctionalityService.addTeamFunctionality(teamFunctionality);
        return "redirect:/teamFunctionalities";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeamFunctionality(@PathVariable("id") Long id) {
        teamFunctionalityService.deleteTeamFunctionality(id);
        return "redirect:/teamFunctionalities";
    }
}