package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pineapple.palapa.model.PointType;
import com.pineapple.palapa.service.PointTypeService;

import java.util.List;

@Controller
@RequestMapping("/pointTypes") 
public class PointTypeController {

    private final PointTypeService pointTypeService;

    public PointTypeController(PointTypeService pointTypeService) {
        this.pointTypeService = pointTypeService;
    }

    @GetMapping("")
    public String getAllPointTypes(PointType pointType, Model model) {
        List<PointType> pointTypes = pointTypeService.findAllPointTypes();
        model.addAttribute("pointTypes", pointTypes);
        model.addAttribute("pageToRender", "/pointTypes/createPointTypes");
        return "index";
    }

    @PostMapping("/add")
    public String addPointType(PointType pointTypes, Model model) {
        pointTypeService.addPointType(pointTypes);
        return "redirect:/pointTypes";
    }

    @GetMapping("/delete/{id}")
    public String deletePointType(@PathVariable("id") Long id) {
        pointTypeService.deletePointType(id);
        return "redirect:/pointTypes";
    }
}