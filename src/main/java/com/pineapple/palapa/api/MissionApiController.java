package com.pineapple.palapa.api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pineapple.palapa.model.Mission;
import com.pineapple.palapa.service.MissionService;

import java.util.List;

@RestController
@RequestMapping("/api/mission")

public class MissionApiController {
    private final MissionService missionService;

    public MissionApiController(MissionService missionService) {
        this.missionService = missionService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<?> getMission(@PathVariable("id") Long id) {
        Mission mission = missionService.getMission(id);
        return new ResponseEntity<>(mission, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Mission>> getAllMissions() {
        List<Mission> missions = missionService.findAllMissions();
        return new ResponseEntity<>(missions, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Mission> addMission(@RequestBody Mission mission) {
        Mission newMission = missionService.addMission(mission);
        return new ResponseEntity<>(newMission, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMission(@PathVariable("id") Long id) {
        missionService.deleteMission(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
