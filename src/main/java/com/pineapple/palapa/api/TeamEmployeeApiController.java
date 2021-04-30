package com.pineapple.palapa.api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pineapple.palapa.model.TeamEmployee;
import com.pineapple.palapa.service.TeamEmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/teamEmployees")

public class TeamEmployeeApiController {
    private final TeamEmployeeService teamEmployeeService;

    public TeamEmployeeApiController(TeamEmployeeService teamEmployeeService) {
        this.teamEmployeeService = teamEmployeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TeamEmployee>> getAllTeamEmployees() {
        List<TeamEmployee> teamEmployees = teamEmployeeService.findAllTeamEmployees();
        return new ResponseEntity<>(teamEmployees, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TeamEmployee> addTeamEmployee(@RequestBody TeamEmployee teamEmployee) {
        TeamEmployee newTeamEmployee = teamEmployeeService.addTeamEmployee(teamEmployee);
        return new ResponseEntity<>(newTeamEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeamEmployee(@PathVariable("id") Long id) {
        teamEmployeeService.deleteTeamEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
