package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pineapple.palapa.model.Vertice;
import com.pineapple.palapa.model.Point;
import com.pineapple.palapa.model.Location;
import com.pineapple.palapa.service.VerticeService;
import com.pineapple.palapa.service.PointService;
import com.pineapple.palapa.service.LocationService;

import java.util.List;

@Controller
@RequestMapping("/vertices") 
public class VerticeController {

    private final VerticeService verticeService;
    private PointService pointService;
    private LocationService locationService;

    public VerticeController(VerticeService verticeService, PointService pointService, LocationService locationService) {
        this.verticeService = verticeService;
        this.pointService = pointService;
        this.locationService = locationService;
    }

    @GetMapping("")
    public String getAllVertices(Vertice vertice, Model model) {
        List<Vertice> vertices = verticeService.findAllVertices();
        model.addAttribute("vertices", vertices);
        model.addAttribute("pageToRender", "/vertices/createVertices");
        
        List<Point> points = pointService.findAllPoints();
        model.addAttribute("points", points);
        List<Location> locations = locationService.findAllLocations();
        model.addAttribute("locations", locations);

        return "index";
    }

    @PostMapping("/add")
    public String addVertice(Vertice vertice, Model model) {
        verticeService.addVertice(vertice);
        return "redirect:/vertices";
    }

    @GetMapping("/delete/{id}")
    public String deleteVertice(@PathVariable("id") Long id) {
        verticeService.deleteVertice(id);
        return "redirect:/vertices";
    }
}