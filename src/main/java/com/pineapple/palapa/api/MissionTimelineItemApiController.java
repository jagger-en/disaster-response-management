package com.pineapple.palapa.api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pineapple.palapa.model.MissionTimelineItem;
import com.pineapple.palapa.service.MissionTimelineItemService;

import java.util.List;

@RestController
@RequestMapping("/api/mission-timeline-items")

public class MissionTimelineItemApiController {
    private final MissionTimelineItemService missionTimelineItemService;

    public MissionTimelineItemApiController(MissionTimelineItemService missionTimelineItemService) {
        this.missionTimelineItemService = missionTimelineItemService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<MissionTimelineItem>> getAllMissionTimelineItem() {
        List<MissionTimelineItem> items = missionTimelineItemService.findAllMissionTimelineItem();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
