package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pineapple.palapa.model.JobTitle;
import com.pineapple.palapa.service.JobTitleService;

import java.util.List;

@Controller
@RequestMapping("/jobTitles") 
public class JobTitleController {

    private final JobTitleService jobTitleService;

    public JobTitleController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("")
    public String getAllJobTitles(JobTitle jobTitle, Model model) {
        List<JobTitle> jobTitles = jobTitleService.findAllJobTitles();
        model.addAttribute("jobTitles", jobTitles);
        model.addAttribute("pageToRender", "/jobTitles/createJobTitles");
        return "index";
    }

    @PostMapping("/add")
    public String addJobTitle(JobTitle jobTitle, Model model) {
        jobTitleService.addJobTitle(jobTitle);
        return "redirect:/jobTitles";
    }

    @GetMapping("/delete/{id}")
    public String deleteJobTitle(@PathVariable("id") Long id) {
        jobTitleService.deleteJobTitle(id);
        return "redirect:/jobTitles";
    }
}