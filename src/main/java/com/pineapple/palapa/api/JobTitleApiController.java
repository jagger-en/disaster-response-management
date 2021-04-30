package com.pineapple.palapa.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pineapple.palapa.model.JobTitle;
import com.pineapple.palapa.service.JobTitleService;

import java.util.List;

@RestController
@RequestMapping("/api/jobTitles") 
public class JobTitleApiController {

    private final JobTitleService jobTitleService;

    public JobTitleApiController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<JobTitle>> getAllJobTitles() {
        List<JobTitle> jobTitles = jobTitleService.findAllJobTitles();
        return new ResponseEntity<>(jobTitles, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<JobTitle> addJobTitle(@RequestBody JobTitle jobTitle) {
        JobTitle newJobTitle = jobTitleService.addJobTitle(jobTitle);
        return new ResponseEntity<>(newJobTitle, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJobTitle(@PathVariable("id") Long id) {
        jobTitleService.deleteJobTitle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}