package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.MissionAndLocation;
import com.pineapple.palapa.repo.MissionAndLocationRepo;

import java.util.List;

@Service
public class MissionAndLocationService {
    private final MissionAndLocationRepo missionTeamRepo;

    @Autowired
    public MissionAndLocationService(MissionAndLocationRepo missionTeamRepo) {
        this.missionTeamRepo = missionTeamRepo;
    }

    public MissionAndLocation addMissionAndLocation(MissionAndLocation missionTeam) {
        return missionTeamRepo.save(missionTeam);
    }

    public List<MissionAndLocation> findAllMissionAndLocations() {
        return missionTeamRepo.findAll();
    }

    public void deleteMissionAndLocation(Long id){
        MissionAndLocation missionTeam = missionTeamRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("MissionAndLocation by id " + id + " was not found"));
        missionTeamRepo.delete(missionTeam);
    }
}
