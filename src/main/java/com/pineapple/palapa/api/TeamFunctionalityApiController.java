package com.pineapple.palapa.api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pineapple.palapa.model.TeamFunctionality;
import com.pineapple.palapa.service.TeamFunctionalityService;

import java.util.List;

@RestController
@RequestMapping("/api/teamFunctionalities")

public class TeamFunctionalityApiController {
    private final TeamFunctionalityService teamFunctionalityService;

    public TeamFunctionalityApiController(TeamFunctionalityService teamFunctionalityService) {
        this.teamFunctionalityService = teamFunctionalityService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TeamFunctionality>> getAllTeamFunctionalities() {
        List<TeamFunctionality> teamFunctionalities = teamFunctionalityService.findAllTeamFunctionalities();
        return new ResponseEntity<>(teamFunctionalities, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TeamFunctionality> addTeamFunctionality(@RequestBody TeamFunctionality teamFunctionality) {
        TeamFunctionality newTeamFunctionality = teamFunctionalityService.addTeamFunctionality(teamFunctionality);
        return new ResponseEntity<>(newTeamFunctionality, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeamFunctionality(@PathVariable("id") Long id) {
        teamFunctionalityService.deleteTeamFunctionality(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
