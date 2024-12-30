package com.pineapple.palapa.api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pineapple.palapa.model.MissionAndStatus;
import com.pineapple.palapa.service.MissionAndStatusService;

import java.util.List;

@RestController
@RequestMapping("/api/mission-and-status")

public class MissionAndStatusApiController {
    private final MissionAndStatusService missionAndStatusService;

    public MissionAndStatusApiController(MissionAndStatusService missionAndStatusService) {
        this.missionAndStatusService = missionAndStatusService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MissionAndStatus>> getAllMissionAndStatuss() {
        List<MissionAndStatus> missionAndStatus = missionAndStatusService.findAllMissionAndStatuss();
        return new ResponseEntity<>(missionAndStatus, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MissionAndStatus> addMissionAndStatus(@RequestBody MissionAndStatus missionAndStatus) {
        MissionAndStatus newMissionAndStatus = missionAndStatusService.addMissionAndStatus(missionAndStatus);
        return new ResponseEntity<>(newMissionAndStatus, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMissionAndStatus(@PathVariable("id") Long id) {
        missionAndStatusService.deleteMissionAndStatus(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
