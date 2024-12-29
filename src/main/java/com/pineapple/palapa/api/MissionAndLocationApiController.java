package com.pineapple.palapa.api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pineapple.palapa.model.MissionAndLocation;
import com.pineapple.palapa.service.MissionAndLocationService;

import java.util.List;

@RestController
@RequestMapping("/api/mission-and-location")

public class MissionAndLocationApiController {
    private final MissionAndLocationService missionAndLocationService;

    public MissionAndLocationApiController(MissionAndLocationService missionAndLocationService) {
        this.missionAndLocationService = missionAndLocationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MissionAndLocation>> getAllMissionAndLocations() {
        List<MissionAndLocation> missionAndLocation = missionAndLocationService.findAllMissionAndLocations();
        return new ResponseEntity<>(missionAndLocation, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MissionAndLocation> addMissionAndLocation(@RequestBody MissionAndLocation missionAndLocation) {
        MissionAndLocation newMissionAndLocation = missionAndLocationService.addMissionAndLocation(missionAndLocation);
        return new ResponseEntity<>(newMissionAndLocation, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMissionAndLocation(@PathVariable("id") Long id) {
        missionAndLocationService.deleteMissionAndLocation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
