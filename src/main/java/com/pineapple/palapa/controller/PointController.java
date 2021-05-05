package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pineapple.palapa.model.Point;
import com.pineapple.palapa.model.PointType;
import com.pineapple.palapa.service.PointService;
import com.pineapple.palapa.service.PointTypeService;

import java.util.List;

@Controller
@RequestMapping("/points") 
public class PointController {

    private final PointService pointService;
    private PointTypeService pointTypeService;

    public PointController(PointService pointService, PointTypeService pointTypeService) {
        this.pointService = pointService;
        this.pointTypeService = pointTypeService;
    }

    @GetMapping("")
    public String getAllPoints(Point point, PointType pointType, Model model) {
        List<Point> points = pointService.findAllPoints();
        List<PointType> pointTypes = pointTypeService.findAllPointTypes();
        model.addAttribute("points", points);
        model.addAttribute("pointTypes", pointTypes);
        model.addAttribute("pageToRender", "/points/createPoints");
        return "index";
    }

    @PostMapping("/add")
    public String addPoint(Point point, Model model) {
        pointService.addPoint(point);
        return "redirect:/points";
    }

    @GetMapping("/delete/{id}")
    public String deletePoint(@PathVariable("id") Long id) {
        pointService.deletePoint(id);
        return "redirect:/points";
    }
}