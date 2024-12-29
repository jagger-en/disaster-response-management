package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.MissionSummary;
import com.pineapple.palapa.repo.MissionSummaryRepo;

import java.util.List;

@Service
public class MissionSummaryService {
    private final MissionSummaryRepo missionSummaryRepo;

    @Autowired
    public MissionSummaryService(MissionSummaryRepo missionSummaryRepo) {
        this.missionSummaryRepo = missionSummaryRepo;
    }

    public MissionSummary addMissionSummary(MissionSummary missionSummary) {
        return missionSummaryRepo.save(missionSummary);
    }

    public List<MissionSummary> findAllMissionSummaries() {
        return missionSummaryRepo.getAllMissionSummaries();
    }

    public void deleteMissionSummary(Long id){
        MissionSummary missionSummary = missionSummaryRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("MissionSummary by id " + id + " was not found"));
        missionSummaryRepo.delete(missionSummary);
    }
}
