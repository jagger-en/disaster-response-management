package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pineapple.palapa.model.Employee;
import com.pineapple.palapa.model.Team;
import com.pineapple.palapa.model.TeamEmployee;
import com.pineapple.palapa.service.EmployeeService;
import com.pineapple.palapa.service.TeamEmployeeService;
import com.pineapple.palapa.service.TeamService;

import java.util.List;

@Controller
@RequestMapping("/teamEmployees") // remember to write @{/teamEmployee/add} instead of @{teamEmployee/add}!!!! a "/" makes a difference!
public class TeamEmployeeController {

    private final TeamEmployeeService teamEmployeeService;
    private TeamService teamService;
    private EmployeeService employeeService;

    public TeamEmployeeController(TeamEmployeeService teamEmployeeService, TeamService teamService, EmployeeService employeeService) {
        this.teamEmployeeService = teamEmployeeService;
        this.teamService = teamService;
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public String getAllTeamEmployees(TeamEmployee teamEmployee, Team team, Employee employee, Model model) {
        List<TeamEmployee> teamEmployees = teamEmployeeService.findAllTeamEmployees();
        model.addAttribute("teamEmployees", teamEmployees);
        model.addAttribute("pageToRender", "/teamEmployees/createTeamEmployees");

        List<Team> teams = teamService.findAllTeams();
        model.addAttribute("teams", teams);

        List<Employee> employees = employeeService.findAllEmployees();
        model.addAttribute("employees", employees);
        
        return "index";
    }

    @PostMapping("/add")
    public String addTeamEmployee(TeamEmployee teamEmployee, Model model) {
        teamEmployeeService.addTeamEmployee(teamEmployee);
        return "redirect:/teamEmployees";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeamEmployee(@PathVariable("id") Long id) {
        teamEmployeeService.deleteTeamEmployee(id);
        return "redirect:/teamEmployees";
    }
}