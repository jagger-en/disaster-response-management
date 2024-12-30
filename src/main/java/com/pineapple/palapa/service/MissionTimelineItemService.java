package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.MissionTimelineItem;
import com.pineapple.palapa.repo.MissionTimelineItemRepo;

import java.util.List;

@Service
public class MissionTimelineItemService {
    private final MissionTimelineItemRepo missionTimelineItemRepo;

    @Autowired
    public MissionTimelineItemService(MissionTimelineItemRepo missionTimelineItemRepo) {
        this.missionTimelineItemRepo = missionTimelineItemRepo;
    }

    public MissionTimelineItem addMissionTimelineItem(MissionTimelineItem missionTimelineItem) {
        return missionTimelineItemRepo.save(missionTimelineItem);
    }

    public List<MissionTimelineItem> findAllMissionTimelineItem() {
        return missionTimelineItemRepo.getAllMissionTimelineItem();
    }

    public void deleteMissionTimelineItem(Long id){
        MissionTimelineItem missionTimelineItem = missionTimelineItemRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("MissionTimelineItem by id " + id + " was not found"));
        missionTimelineItemRepo.delete(missionTimelineItem);
    }
}
