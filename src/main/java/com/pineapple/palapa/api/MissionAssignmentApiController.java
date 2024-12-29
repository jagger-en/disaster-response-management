package com.pineapple.palapa.api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pineapple.palapa.model.MissionAssignment;
import com.pineapple.palapa.service.MissionAssignmentService;

import java.util.List;

@RestController
@RequestMapping("/api/mission-assignment")

public class MissionAssignmentApiController {
    private final MissionAssignmentService missionAssignmentService;

    public MissionAssignmentApiController(MissionAssignmentService missionAssignmentService) {
        this.missionAssignmentService = missionAssignmentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MissionAssignment>> getAllMissionAssignments() {
        List<MissionAssignment> missionAssignment = missionAssignmentService.findAllMissionAssignments();
        return new ResponseEntity<>(missionAssignment, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MissionAssignment> addMissionAssignment(@RequestBody MissionAssignment missionAssignment) {
        MissionAssignment newMissionAssignment = missionAssignmentService.addMissionAssignment(missionAssignment);
        return new ResponseEntity<>(newMissionAssignment, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMissionAssignment(@PathVariable("id") Long id) {
        missionAssignmentService.deleteMissionAssignment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
