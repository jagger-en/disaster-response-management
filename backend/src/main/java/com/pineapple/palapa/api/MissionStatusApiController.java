package com.pineapple.palapa.api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pineapple.palapa.model.MissionStatus;
import com.pineapple.palapa.service.MissionStatusService;

import java.util.List;

@RestController
@RequestMapping("/api/mission-status")

public class MissionStatusApiController {
    private final MissionStatusService missionStatusService;

    public MissionStatusApiController(MissionStatusService missionStatusService) {
        this.missionStatusService = missionStatusService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MissionStatus>> getAllMissionStatuss() {
        List<MissionStatus> missionStatuses = missionStatusService.findAllMissionStatuss();
        return new ResponseEntity<>(missionStatuses, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MissionStatus> addMissionStatus(@RequestBody MissionStatus missionStatus) {
        MissionStatus newMissionStatus = missionStatusService.addMissionStatus(missionStatus);
        return new ResponseEntity<>(newMissionStatus, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMissionStatus(@PathVariable("id") Long id) {
        missionStatusService.deleteMissionStatus(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
