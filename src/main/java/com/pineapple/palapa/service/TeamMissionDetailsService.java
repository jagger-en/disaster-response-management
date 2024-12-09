package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.TeamMissionDetails;
import com.pineapple.palapa.repo.TeamMissionDetailsRepo;

import java.util.List;

@Service
public class TeamMissionDetailsService {
    private final TeamMissionDetailsRepo teamMissionDetailsRepo;

    @Autowired
    public TeamMissionDetailsService(TeamMissionDetailsRepo teamMissionDetailsRepo) {
        this.teamMissionDetailsRepo = teamMissionDetailsRepo;
    }

    public TeamMissionDetails addTeamMissionDetails(TeamMissionDetails item) {
        return teamMissionDetailsRepo.save(item);
    }

    public List<TeamMissionDetails> findAllTeamMissionDetails() {
        return teamMissionDetailsRepo.getAllTeamMissionDetails();
    }

    public void deleteTeamMissionDetails(Long id){
        TeamMissionDetails item = teamMissionDetailsRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("TeamMissionDetails by id " + id + " was not found"));
        teamMissionDetailsRepo.delete(item);
    }
}
