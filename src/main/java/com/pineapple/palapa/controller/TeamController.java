package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pineapple.palapa.model.Team;
import com.pineapple.palapa.model.TeamFunctionality;
import com.pineapple.palapa.service.TeamService;
import com.pineapple.palapa.service.TeamFunctionalityService;

import java.util.List;

@Controller
@RequestMapping("/team") // remember to write @{/team/add} instead of @{team/add}!!!! a "/" makes a difference!
public class TeamController {

    private final TeamService teamService;
    private TeamFunctionalityService teamFunctionalityService;

    public TeamController(TeamService teamService, TeamFunctionalityService teamFunctionalityService) {
        this.teamService = teamService;
        this.teamFunctionalityService = teamFunctionalityService;
    }

    @GetMapping("")
    public String getAllTeams(Team team, TeamFunctionality teamFunctionality, Model model) {
        List<Team> teams = teamService.findAllTeams();
        List<TeamFunctionality> teamFunctionalities = teamFunctionalityService.findAllTeamFunctionalities();
        model.addAttribute("teams", teams);
        model.addAttribute("teamFunctionalities", teamFunctionalities);
        model.addAttribute("pageToRender", "/teams/createTeams");
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