package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pineapple.palapa.model.Mission;
import com.pineapple.palapa.model.MissionTeam;
import com.pineapple.palapa.model.Team;
import com.pineapple.palapa.service.MissionService;
import com.pineapple.palapa.service.MissionTeamService;
import com.pineapple.palapa.service.TeamService;

import java.util.List;

@Controller
@RequestMapping("/missionTeams") 
public class MissionTeamController {

    private final MissionTeamService missionTeamService;
    private MissionService missionService;
    private TeamService teamService;

    public MissionTeamController(MissionTeamService missionTeamService, MissionService missionService, TeamService teamService) {
        this.missionTeamService = missionTeamService;
        this.missionService = missionService;
        this.teamService = teamService;
    }

    @GetMapping("")
    public String getAllMissionTeams(MissionTeam missionTeam, Mission mission, Team team, Model model) {
        List<MissionTeam> missionTeams = missionTeamService.findAllMissionTeams();
        model.addAttribute("missionTeams", missionTeams);
        model.addAttribute("pageToRender", "/missionTeams/createMissionTeams");


        List<Mission> missions = missionService.findAllMissions();
        model.addAttribute("missions", missions);

        List<Team> teams = teamService.findAllTeams();
        model.addAttribute("teams", teams);


        return "index";
    }

    @PostMapping("/add")
    public String addMissionTeam(MissionTeam missionTeam, Model model) {
        missionTeamService.addMissionTeam(missionTeam);
        return "redirect:/missionTeams";
    }

    @GetMapping("/delete/{id}")
    public String deleteMissionTeam(@PathVariable("id") Long id) {
        missionTeamService.deleteMissionTeam(id);
        return "redirect:/missionTeams";
    }
}