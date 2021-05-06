package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.Summary;
import com.pineapple.palapa.repo.SummaryRepo;

import java.util.List;

@Service
public class SummaryService {
    private final SummaryRepo summaryRepo;

    @Autowired
    public SummaryService(SummaryRepo summaryRepo) {
        this.summaryRepo = summaryRepo;
    }

    public Summary addSummary(Summary summary) {
        return summaryRepo.save(summary);
    }

    public List<Summary> findAllSummaries() {
        return summaryRepo.getAllSummaries();
    }

    public void deleteSummary(Long id){
        Summary summary = summaryRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("Summary by id " + id + " was not found"));
        summaryRepo.delete(summary);
    }
}
