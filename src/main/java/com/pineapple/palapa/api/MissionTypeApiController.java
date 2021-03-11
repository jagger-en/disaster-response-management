package com.pineapple.palapa.api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pineapple.palapa.model.MissionType;
import com.pineapple.palapa.service.MissionTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/missionTypes")

public class MissionTypeApiController {
    private final MissionTypeService missionTypeService;

    public MissionTypeApiController(MissionTypeService missionTypeService) {
        this.missionTypeService = missionTypeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MissionType>> getAllMissionTypes() {
        List<MissionType> missionTypes = missionTypeService.findAllMissionTypes();
        return new ResponseEntity<>(missionTypes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<MissionType> getMissionTypeById(@PathVariable("id") Long id) {
        MissionType missionType = missionTypeService.findMissionTypeById(id);
        return new ResponseEntity<>(missionType, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MissionType> addMissionType(@RequestBody MissionType missionType) {
        MissionType newMissionType = missionTypeService.addMissionType(missionType);
        return new ResponseEntity<>(newMissionType, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMissionType(@PathVariable("id") Long id) {
        missionTypeService.deleteMissionType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
