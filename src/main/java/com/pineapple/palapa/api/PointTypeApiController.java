package com.pineapple.palapa.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pineapple.palapa.model.PointType;
import com.pineapple.palapa.service.PointTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/pointTypes") 
public class PointTypeApiController {

    private final PointTypeService pointTypeService;

    public PointTypeApiController(PointTypeService pointTypeService) {
        this.pointTypeService = pointTypeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PointType>> getAllPointTypes() {
        List<PointType> pointTypes = pointTypeService.findAllPointTypes();
        return new ResponseEntity<>(pointTypes, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PointType> addPointType(@RequestBody PointType pointType) {
        PointType newPointType = pointTypeService.addPointType(pointType);
        return new ResponseEntity<>(newPointType, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePointType(@PathVariable("id") Long id) {
        pointTypeService.deletePointType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}