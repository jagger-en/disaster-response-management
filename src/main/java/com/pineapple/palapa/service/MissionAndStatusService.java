package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.MissionAndStatus;
import com.pineapple.palapa.repo.MissionAndStatusRepo;

import java.util.List;

@Service
public class MissionAndStatusService {
    private final MissionAndStatusRepo missionAndStatusRepo;

    @Autowired
    public MissionAndStatusService(MissionAndStatusRepo missionAndStatusRepo) {
        this.missionAndStatusRepo = missionAndStatusRepo;
    }

    public MissionAndStatus addMissionAndStatus(MissionAndStatus missionAndStatus) {
        return missionAndStatusRepo.save(missionAndStatus);
    }

    public List<MissionAndStatus> findAllMissionAndStatuss() {
        return missionAndStatusRepo.findAll();
    }

    public void deleteMissionAndStatus(Long id){
        MissionAndStatus missionAndStatus = missionAndStatusRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("MissionAndStatus by id " + id + " was not found"));
        missionAndStatusRepo.delete(missionAndStatus);
    }
}
