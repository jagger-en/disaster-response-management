package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pineapple.palapa.model.Point;
import com.pineapple.palapa.service.PointService;

import java.util.List;

@Controller
@RequestMapping("/points") 
public class PointController {

    private final PointService pointService;

    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping("")
    public String getAllPoints(Point point, Model model) {
        List<Point> points = pointService.findAllPoints();
        model.addAttribute("points", points);
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