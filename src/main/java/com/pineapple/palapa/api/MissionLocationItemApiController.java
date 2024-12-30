package com.pineapple.palapa.api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pineapple.palapa.model.MissionLocationItem;
import com.pineapple.palapa.service.MissionLocationItemService;

import java.util.List;

@RestController
@RequestMapping("/api/mission-location-items")

public class MissionLocationItemApiController {
    private final MissionLocationItemService missionlocationItemService;

    public MissionLocationItemApiController(MissionLocationItemService missionlocationItemService) {
        this.missionlocationItemService = missionlocationItemService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<MissionLocationItem>> getAllMissionLocationItem() {
        List<MissionLocationItem> items = missionlocationItemService.findAllMissionLocationItem();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
