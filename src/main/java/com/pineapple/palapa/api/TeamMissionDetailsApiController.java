package com.pineapple.palapa.api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pineapple.palapa.model.TeamMissionDetails;
import com.pineapple.palapa.service.TeamMissionDetailsService;

import java.util.List;

@RestController
@RequestMapping("/api/team-mission-details")

public class TeamMissionDetailsApiController {
    private final TeamMissionDetailsService teamMissionDetailsService;

    public TeamMissionDetailsApiController(TeamMissionDetailsService teamMissionDetailsService) {
        this.teamMissionDetailsService = teamMissionDetailsService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<TeamMissionDetails>> getAllTeamMissionDetails() {
        List<TeamMissionDetails> teamMissionDetails = teamMissionDetailsService.findAllTeamMissionDetails();
        return new ResponseEntity<>(teamMissionDetails, HttpStatus.OK);
    }
}
