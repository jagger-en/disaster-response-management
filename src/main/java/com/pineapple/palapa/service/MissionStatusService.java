package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.MissionStatus;
import com.pineapple.palapa.repo.MissionStatusRepo;

import java.util.List;

@Service
public class MissionStatusService {
    private final MissionStatusRepo missionTypeRepo;

    @Autowired
    public MissionStatusService(MissionStatusRepo missionTypeRepo) {
        this.missionTypeRepo = missionTypeRepo;
    }

    public MissionStatus addMissionStatus(MissionStatus missionType) {
        return missionTypeRepo.save(missionType);
    }

    public List<MissionStatus> findAllMissionStatuss() {
        return missionTypeRepo.findAll();
    }

    public void deleteMissionStatus(Long id){
        MissionStatus missionType = missionTypeRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("MissionStatus by id " + id + " was not found"));
        missionTypeRepo.delete(missionType);
    }
}
