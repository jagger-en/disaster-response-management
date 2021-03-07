package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import com.pineapple.palapa.model.Employee;
import com.pineapple.palapa.model.Person;
import com.pineapple.palapa.model.JobTitle;
import com.pineapple.palapa.service.EmployeeService;
import com.pineapple.palapa.service.PersonService;
import com.pineapple.palapa.service.JobTitleService;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private PersonService personService;
    private JobTitleService jobTitleService;

    public EmployeeController(EmployeeService employeeService, PersonService personService, JobTitleService jobTitleService) {
        this.employeeService = employeeService;
        this.personService = personService;
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("")
    public String createEmployees(Employee employee, Person person, JobTitle jobTitle, Model model) {
        
        List<Employee> employees = employeeService.findAllEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("pageToRender", "/employees/createEmployees");

        List<Person> persons = personService.findAllPersons();
        model.addAttribute("persons", persons);

        List<JobTitle> jobTitles = jobTitleService.findAllJobTitles();
        model.addAttribute("jobTitles", jobTitles);

        return "index";
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

     @GetMapping("/find/{id}")
     public String getEmployeeById (@PathVariable("id") Long id) {
         Employee employee = employeeService.findEmployeeById(id);
         return "index";
     }

     @PostMapping("/update")
     public String updateEmployee(@RequestBody Employee employee) {
         employeeService.updateEmployee(employee);
         return "index";
     }
}