package com.pineapple.palapa.api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pineapple.palapa.model.MissionSummary;
import com.pineapple.palapa.service.MissionSummaryService;

import java.util.List;

@RestController
@RequestMapping("/api/mission-summaries")

public class MissionSummaryApiController {
    private final MissionSummaryService missionSummaryService;

    public MissionSummaryApiController(MissionSummaryService missionSummaryService) {
        this.missionSummaryService = missionSummaryService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<MissionSummary>> getAllMissionSummaries() {
        List<MissionSummary> summaries = missionSummaryService.findAllMissionSummaries();
        return new ResponseEntity<>(summaries, HttpStatus.OK);
    }
}
