package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.Location;
import com.pineapple.palapa.repo.LocationRepo;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepo locationRepo;

    @Autowired
    public LocationService(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    public Location addLocation(Location location) {
        return locationRepo.save(location);
    }

    public List<Location> findAllLocations() {
        return locationRepo.findAll();
    }

    public Location findLocationById(Long id) {
        return locationRepo.findLocationById(id)
            .orElseThrow(() -> new UserNotFoundException("Location by id " + id + " was not found"));
    }

    public void deleteLocation(Long id){
        Location location = locationRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("Location by id " + id + " was not found"));
        locationRepo.delete(location);
    }
}
