package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.MissionType;
import com.pineapple.palapa.repo.MissionTypeRepo;

import java.util.List;

@Service
public class MissionTypeService {
    private final MissionTypeRepo missionTypeRepo;

    @Autowired
    public MissionTypeService(MissionTypeRepo missionTypeRepo) {
        this.missionTypeRepo = missionTypeRepo;
    }

    public MissionType addMissionType(MissionType missionType) {
        return missionTypeRepo.save(missionType);
    }

    public List<MissionType> findAllMissionTypes() {
        return missionTypeRepo.findAll();
    }

    public void deleteMissionType(Long id){
        MissionType missionType = missionTypeRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("MissionType by id " + id + " was not found"));
        missionTypeRepo.delete(missionType);
    }
}
