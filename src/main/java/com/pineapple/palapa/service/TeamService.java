package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.Team;
import com.pineapple.palapa.repo.TeamRepo;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepo teamRepo;

    @Autowired
    public TeamService(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }

    public Team addTeam(Team Team) {
        return teamRepo.save(Team);
    }

    public List<Team> findAllTeams() {
        return teamRepo.findAll();
    }

    public Team findTeamById(Long id) {
        return teamRepo.findTeamById(id)
            .orElseThrow(() -> new UserNotFoundException("Team by id " + id + " was not found"));
    }

    public void deleteTeam(Long id){
        Team team = teamRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
        teamRepo.delete(team);
    }
}
