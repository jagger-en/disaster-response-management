package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pineapple.palapa.model.Location;
import com.pineapple.palapa.service.LocationService;

import java.util.List;

@Controller
@RequestMapping("/locations") 
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("")
    public String getAllLocations(Location Location, Model model) {
        List<Location> locations = locationService.findAllLocations();
        model.addAttribute("locations", locations);
        model.addAttribute("pageToRender", "/locations/createlocations");
        return "base";
    }

    @PostMapping("/add")
    public String addLocation(Location Location, Model model) {
        locationService.addLocation(Location);
        return "redirect:/locations";
    }

    @GetMapping("/delete/{id}")
    public String deleteLocation(@PathVariable("id") Long id) {
        locationService.deleteLocation(id);
        return "redirect:/locations";
    }
}