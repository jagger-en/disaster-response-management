package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.MissionAssignment;
import com.pineapple.palapa.repo.MissionAssignmentRepo;

import java.util.List;

@Service
public class MissionAssignmentService {
    private final MissionAssignmentRepo missionTeamRepo;

    @Autowired
    public MissionAssignmentService(MissionAssignmentRepo missionTeamRepo) {
        this.missionTeamRepo = missionTeamRepo;
    }

    public MissionAssignment addMissionAssignment(MissionAssignment missionTeam) {
        return missionTeamRepo.save(missionTeam);
    }

    public List<MissionAssignment> findAllMissionAssignments() {
        return missionTeamRepo.findAll();
    }

    public void deleteMissionAssignment(Long id){
        MissionAssignment missionTeam = missionTeamRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("MissionAssignment by id " + id + " was not found"));
        missionTeamRepo.delete(missionTeam);
    }
}
