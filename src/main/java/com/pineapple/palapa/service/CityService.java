package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.City;
import com.pineapple.palapa.repo.CityRepo;

import java.util.List;

@Service
public class CityService {
    private final CityRepo cityRepo;

    @Autowired
    public CityService(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public City addCity(City city) {
        return cityRepo.save(city);
    }

    public List<City> findAllCities() {
        return cityRepo.getAllCities();
    }

    public void deleteCity(Long id){
        City city = cityRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("City by id " + id + " was not found"));
        cityRepo.delete(city);
    }
}
