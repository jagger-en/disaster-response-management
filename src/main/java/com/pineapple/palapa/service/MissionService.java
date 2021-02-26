package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.Mission;
import com.pineapple.palapa.repo.MissionRepo;

import java.util.List;

@Service
public class MissionService {
    private final MissionRepo missionRepo;

    @Autowired
    public MissionService(MissionRepo missionRepo) {
        this.missionRepo = missionRepo;
    }

    public Mission addMission(Mission mission) {
        return missionRepo.save(mission);
    }

    public List<Mission> findAllMissions() {
        return missionRepo.findAll();
    }

    public Mission findMissionById(Long id) {
        return missionRepo.findMissionById(id)
            .orElseThrow(() -> new UserNotFoundException("Mission by id " + id + " was not found"));
    }

    public void deleteMission(Long id){
        Mission mission = missionRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("Mission by id " + id + " was not found"));
        missionRepo.delete(mission);
    }
}
