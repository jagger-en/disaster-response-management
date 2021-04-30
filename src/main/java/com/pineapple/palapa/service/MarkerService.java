package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.model.Marker;
import com.pineapple.palapa.repo.MarkerRepo;

import java.util.List;

@Service
public class MarkerService {
    private final MarkerRepo markerRepo;

    @Autowired
    public MarkerService(MarkerRepo markerRepo) {
        this.markerRepo = markerRepo;
    }

    public List<Marker> findAllMarkers() {
        return markerRepo.getAllMarkers();
    }
}
