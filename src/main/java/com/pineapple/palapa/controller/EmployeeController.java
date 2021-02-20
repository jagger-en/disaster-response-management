package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pineapple.palapa.model.Employee;
import com.pineapple.palapa.model.Person;
import com.pineapple.palapa.model.JobTitle;
import com.pineapple.palapa.model.Team;
import com.pineapple.palapa.service.EmployeeService;
import com.pineapple.palapa.service.PersonService;
import com.pineapple.palapa.service.JobTitleService;
import com.pineapple.palapa.service.TeamService;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private PersonService personService;
    private JobTitleService jobTitleService;
    private TeamService teamService;

    public EmployeeController(EmployeeService employeeService, PersonService personService, JobTitleService jobTitleService, TeamService teamService) {
        this.employeeService = employeeService;
        this.personService = personService;
        this.jobTitleService = jobTitleService;
        this.teamService = teamService;
    }

    @GetMapping("")
    public String createEmployees(Employee employee, Person person, JobTitle jobTitle, Team team, Model model) {
        
        List<Employee> employees = employeeService.findAllEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("pageToRender", "/employees/createEmployees");

        List<Person> persons = personService.findAllPersons();
        model.addAttribute("persons", persons);

        List<JobTitle> jobTitles = jobTitleService.findAllJobTitles();
        model.addAttribute("jobTitles", jobTitles);

        List<Team> teams = teamService.findAllTeams();
        model.addAttribute("teams", teams);

        return "base";
    }

    @PostMapping("/add")
    public String addEmployee(Employee employee, Model model) {
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    // @GetMapping("/find/{id}")
    // public String getEmployeeById (@PathVariable("id") Long id) {
    //     Employee employee = employeeService.findEmployeeById(id);
    //     return "base";
    // }

    // @PostMapping("/update")
    // public String updateEmployee(@RequestBody Employee employee) {
    //     Employee updateEmployee = employeeService.updateEmployee(employee);
    //     return "base";
    // }
}