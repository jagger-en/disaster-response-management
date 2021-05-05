package com.pineapple.palapa.api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pineapple.palapa.functions.ShortestPath;
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

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<Marker>> getAllMarkers() {
        try {
            System.out.println("[::MESSAGE::] Finding ShortestPath...");
            int graph[][] = new int[][] { 
                    { 0, 2, 1, 0, 0, 0},
                    { 2, 0, 7, 0, 8, 4},
                    { 1, 7, 0, 7, 0, 3},
                    { 0, 0, 7, 0, 8, 4},
                    { 0, 8, 0, 8, 0, 5},
                    { 0, 4, 3, 4, 5, 0} };
            ShortestPath g = new ShortestPath();
            g.algo_dijkstra(graph, 0);
        } catch (Exception e) {
            System.out.println("FAILED ALGORITHM");
            System.out.println(e);
        }

        List<Marker> markers = markerService.findAllMarkers();
        return new ResponseEntity<>(markers, HttpStatus.OK);
    }
}
