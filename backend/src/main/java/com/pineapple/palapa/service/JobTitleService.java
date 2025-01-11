package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.JobTitle;
import com.pineapple.palapa.repo.JobTitleRepo;

import java.util.List;

@Service
public class JobTitleService {
    private final JobTitleRepo jobTitleRepo;

    @Autowired
    public JobTitleService(JobTitleRepo jobTitleRepo) {
        this.jobTitleRepo = jobTitleRepo;
    }

    public JobTitle addJobTitle(JobTitle jobTitle) {
        return jobTitleRepo.save(jobTitle);
    }

    public List<JobTitle> findAllJobTitles() {
        return jobTitleRepo.findAll();
    }

    public void deleteJobTitle(Long id){
        JobTitle jobTitle = jobTitleRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("JobTitle by id " + id + " was not found"));
        jobTitleRepo.delete(jobTitle);
    }
}
