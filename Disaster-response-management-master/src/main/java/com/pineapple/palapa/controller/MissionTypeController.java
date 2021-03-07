package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pineapple.palapa.model.MissionType;
import com.pineapple.palapa.service.MissionTypeService;

import java.util.List;

@Controller
@RequestMapping("/missionTypes") 
public class MissionTypeController {

    private final MissionTypeService missionTypeService;

    public MissionTypeController(MissionTypeService missionTypeService) {
        this.missionTypeService = missionTypeService;
    }

    @GetMapping("")
    public String getAllMissionTypes(MissionType missionType, Model model) {
        List<MissionType> missionTypes = missionTypeService.findAllMissionTypes();
        model.addAttribute("missionTypes", missionTypes);
        model.addAttribute("pageToRender", "/missionTypes/createMissionTypes");
        return "index";
    }

    @PostMapping("/add")
    public String addMissionType(MissionType missionType, Model model) {
        missionTypeService.addMissionType(missionType);
        return "redirect:/missionTypes";
    }

    @GetMapping("/delete/{id}")
    public String deleteMissionType(@PathVariable("id") Long id) {
        missionTypeService.deleteMissionType(id);
        return "redirect:/missionTypes";
    }
}