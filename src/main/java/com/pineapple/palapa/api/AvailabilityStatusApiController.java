package com.pineapple.palapa.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pineapple.palapa.model.AvailabilityStatus;
import com.pineapple.palapa.service.AvailabilityStatusService;

import java.util.List;

@RestController
@RequestMapping("/api/availability-status")
public class AvailabilityStatusApiController {

    private final AvailabilityStatusService availabilityStatusService;

    public AvailabilityStatusApiController(AvailabilityStatusService availabilityStatusService) {
        this.availabilityStatusService = availabilityStatusService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AvailabilityStatus>> getAllAvailabilityStatuss() {
        List<AvailabilityStatus> availabilityStatuses = availabilityStatusService.findAllAvailabilityStatuses();
        return new ResponseEntity<>(availabilityStatuses, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AvailabilityStatus> addAvailabilityStatus(@RequestBody AvailabilityStatus availabilityStatus) {
        AvailabilityStatus newAvailabilityStatus = availabilityStatusService.addAvailabilityStatus(availabilityStatus);
        return new ResponseEntity<>(newAvailabilityStatus, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAvailabilityStatus(@PathVariable("id") Long id) {
        availabilityStatusService.deleteAvailabilityStatus(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
