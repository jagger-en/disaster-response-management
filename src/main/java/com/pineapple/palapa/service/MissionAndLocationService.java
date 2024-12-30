package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.MissionAndLocation;
import com.pineapple.palapa.repo.MissionAndLocationRepo;

import java.util.List;

@Service
public class MissionAndLocationService {
    private final MissionAndLocationRepo missionAndLocationRepo;

    @Autowired
    public MissionAndLocationService(MissionAndLocationRepo missionAndLocationRepo) {
        this.missionAndLocationRepo = missionAndLocationRepo;
    }

    public MissionAndLocation addMissionAndLocation(MissionAndLocation missionTeam) {
        return missionAndLocationRepo.save(missionTeam);
    }

    public List<MissionAndLocation> findAllMissionAndLocations() {
        return missionAndLocationRepo.findAll();
    }

    public void deleteMissionAndLocation(Long id){
        MissionAndLocation missionTeam = missionAndLocationRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("MissionAndLocation by id " + id + " was not found"));
        missionAndLocationRepo.delete(missionTeam);
    }
}
