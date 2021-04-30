package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.TeamEmployee;
import com.pineapple.palapa.repo.TeamEmployeeRepo;

import java.util.List;

@Service
public class TeamEmployeeService {
    private final TeamEmployeeRepo teamEmployeeRepo;

    @Autowired
    public TeamEmployeeService(TeamEmployeeRepo teamEmployeeRepo) {
        this.teamEmployeeRepo = teamEmployeeRepo;
    }

    public TeamEmployee addTeamEmployee(TeamEmployee TeamEmployee) {
        return teamEmployeeRepo.save(TeamEmployee);
    }

    public List<TeamEmployee> findAllTeamEmployees() {
        return teamEmployeeRepo.findAll();
    }

    public void deleteTeamEmployee(Long id){
        TeamEmployee teamEmployee = teamEmployeeRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
        teamEmployeeRepo.delete(teamEmployee);
    }
}
