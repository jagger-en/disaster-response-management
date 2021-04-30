package com.pineapple.palapa.api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pineapple.palapa.model.Marker;
import com.pineapple.palapa.service.MarkerService;

import java.util.List;

@RestController
@RequestMapping("/api/markers")

public class MarkerApiController {
    private final MarkerService markerService;

    public MarkerApiController(MarkerService markerService) {
        this.markerService = markerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Marker>> getAllMarkers() {
        List<Marker> markers = markerService.findAllMarkers();
        return new ResponseEntity<>(markers, HttpStatus.OK);
    }
}
