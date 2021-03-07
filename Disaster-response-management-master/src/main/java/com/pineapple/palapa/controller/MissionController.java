package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pineapple.palapa.model.Location;
import com.pineapple.palapa.model.Mission;
import com.pineapple.palapa.model.MissionType;
import com.pineapple.palapa.service.LocationService;
import com.pineapple.palapa.service.MissionService;
import com.pineapple.palapa.service.MissionTypeService;

import java.util.List;

@Controller
@RequestMapping("/missions") 
public class MissionController {

    private final MissionService missionService;
    private MissionTypeService missionTypeService;
    private LocationService locationService;

    public MissionController(MissionService missionService, MissionTypeService missionTypeService, LocationService locationService) {
        this.missionService = missionService;
        this.missionTypeService = missionTypeService;
        this.locationService = locationService;
    }

    @GetMapping("")
    public String getAllMissions(Mission mission, MissionType missionType, Location location, Model model) {
        List<Mission> missions = missionService.findAllMissions();
        model.addAttribute("missions", missions);
        model.addAttribute("pageToRender", "/missions/createMissions");

        List<MissionType> missionTypes = missionTypeService.findAllMissionTypes();
        model.addAttribute("missionTypes", missionTypes);

        List<Location> locations = locationService.findAllLocations();
        model.addAttribute("locations", locations);

        return "index";
    }

    @PostMapping("/add")
    public String addMission(Mission mission, Model model) {
        missionService.addMission(mission);
        return "redirect:/missions";
    }

    @GetMapping("/delete/{id}")
    public String deleteMission(@PathVariable("id") Long id) {
        missionService.deleteMission(id);
        return "redirect:/missions";
    }
}