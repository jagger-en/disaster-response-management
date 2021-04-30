package com.pineapple.palapa.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pineapple.palapa.model.Point;
import com.pineapple.palapa.service.PointService;

import java.util.List;

@RestController
@RequestMapping("/api/points") 
public class PointApiController {

    private final PointService pointService;

    public PointApiController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Point>> getAllPoints() {
        List<Point> points = pointService.findAllPoints();
        return new ResponseEntity<>(points, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Point> addPoint(@RequestBody Point point) {
        Point newPoint = pointService.addPoint(point);
        return new ResponseEntity<>(newPoint, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePoint(@PathVariable("id") Long id) {
        pointService.deletePoint(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}