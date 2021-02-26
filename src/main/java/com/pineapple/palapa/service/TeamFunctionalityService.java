package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.TeamFunctionality;
import com.pineapple.palapa.repo.TeamFunctionalityRepo;

import java.util.List;

@Service
public class TeamFunctionalityService {
    private final TeamFunctionalityRepo teamFunctionalityRepo;

    @Autowired
    public TeamFunctionalityService(TeamFunctionalityRepo teamFunctionalityRepo) {
        this.teamFunctionalityRepo = teamFunctionalityRepo;
    }

    public TeamFunctionality addTeamFunctionality(TeamFunctionality TeamFunctionality) {
        return teamFunctionalityRepo.save(TeamFunctionality);
    }

    public List<TeamFunctionality> findAllTeamFunctionalities() {
        return teamFunctionalityRepo.findAll();
    }

    public TeamFunctionality findTeamFunctionalityById(Long id) {
        return teamFunctionalityRepo.findTeamFunctionalityById(id)
            .orElseThrow(() -> new UserNotFoundException("TeamFunctionality by id " + id + " was not found"));
    }

    public void deleteTeamFunctionality(Long id){
        TeamFunctionality teamFunctionality = teamFunctionalityRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("TeamFunctionality by id " + id + " was not found"));
        teamFunctionalityRepo.delete(teamFunctionality);
    }
}
