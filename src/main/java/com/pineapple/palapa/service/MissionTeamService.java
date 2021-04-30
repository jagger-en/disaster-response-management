package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.MissionTeam;
import com.pineapple.palapa.repo.MissionTeamRepo;

import java.util.List;

@Service
public class MissionTeamService {
    private final MissionTeamRepo missionTeamRepo;

    @Autowired
    public MissionTeamService(MissionTeamRepo missionTeamRepo) {
        this.missionTeamRepo = missionTeamRepo;
    }

    public MissionTeam addMissionTeam(MissionTeam missionTeam) {
        return missionTeamRepo.save(missionTeam);
    }

    public List<MissionTeam> findAllMissionTeams() {
        return missionTeamRepo.findAll();
    }

    public void deleteMissionTeam(Long id){
        MissionTeam missionTeam = missionTeamRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("MissionTeam by id " + id + " was not found"));
        missionTeamRepo.delete(missionTeam);
    }
}
