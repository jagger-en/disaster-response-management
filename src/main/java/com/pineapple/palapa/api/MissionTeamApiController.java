package com.pineapple.palapa.api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pineapple.palapa.model.MissionTeam;
import com.pineapple.palapa.service.MissionTeamService;

import java.util.List;

@RestController
@RequestMapping("/api/missionTeams")

public class MissionTeamApiController {
    private final MissionTeamService missionTeamService;

    public MissionTeamApiController(MissionTeamService missionTeamService) {
        this.missionTeamService = missionTeamService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MissionTeam>> getAllMissionTeams() {
        List<MissionTeam> missionTeams = missionTeamService.findAllMissionTeams();
        return new ResponseEntity<>(missionTeams, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MissionTeam> addMissionTeam(@RequestBody MissionTeam missionTeam) {
        MissionTeam newMissionTeam = missionTeamService.addMissionTeam(missionTeam);
        return new ResponseEntity<>(newMissionTeam, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMissionTeam(@PathVariable("id") Long id) {
        missionTeamService.deleteMissionTeam(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
