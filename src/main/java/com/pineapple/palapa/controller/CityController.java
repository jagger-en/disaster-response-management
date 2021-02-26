package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pineapple.palapa.model.City;
import com.pineapple.palapa.service.CityService;

import java.util.List;

@Controller
@RequestMapping("/cities") 
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("")
    public String getAllCitys(City city, Model model) {
        List<City> cities = cityService.findAllCities();
        model.addAttribute("cities", cities);
        model.addAttribute("pageToRender", "/cities/createCities");
        return "index";
    }

    @PostMapping("/add")
    public String addCity(City city, Model model) {
        cityService.addCity(city);
        return "redirect:/cities";
    }

    @GetMapping("/delete/{id}")
    public String deleteCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
        return "redirect:/cities";
    }
}