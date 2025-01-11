package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.MissionLocationItem;
import com.pineapple.palapa.repo.MissionLocationItemRepo;

import java.util.List;

@Service
public class MissionLocationItemService {
    private final MissionLocationItemRepo missionLocationItemRepo;

    @Autowired
    public MissionLocationItemService(MissionLocationItemRepo missionLocationItemRepo) {
        this.missionLocationItemRepo = missionLocationItemRepo;
    }

    public MissionLocationItem addMissionLocationItem(MissionLocationItem missionLocationItem) {
        return missionLocationItemRepo.save(missionLocationItem);
    }

    public List<MissionLocationItem> findAllMissionLocationItem() {
        return missionLocationItemRepo.getAllMissionLocationItem();
    }

    public void deleteMissionLocationItem(Long id){
        MissionLocationItem missionLocationItem = missionLocationItemRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("MissionLocationItem by id " + id + " was not found"));
        missionLocationItemRepo.delete(missionLocationItem);
    }
}
