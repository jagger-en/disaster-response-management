package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pineapple.palapa.model.Team;
import com.pineapple.palapa.service.TeamService;

import java.util.List;

@Controller
@RequestMapping("/team") // remember to write @{/team/add} instead of @{team/add}!!!! a "/" makes a difference!
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("")
    public String getAllTeams(Team team, Model model) {
        List<Team> teams = teamService.findAllTeams();
        model.addAttribute("teams", teams);
        model.addAttribute("pageToRender", "createTeams");
        return "base";
    }

    @PostMapping("/add")
    public String addTeam(Team team, Model model) {
        teamService.addTeam(team);
        return "redirect:/team";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeam(@PathVariable("id") Long id) {
        teamService.deleteTeam(id);
        return "redirect:/team";
    }
}