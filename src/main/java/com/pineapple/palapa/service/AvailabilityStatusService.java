package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.AvailabilityStatus;
import com.pineapple.palapa.repo.AvailabilityStatusRepo;

import java.util.List;

@Service
public class AvailabilityStatusService {
    private final AvailabilityStatusRepo employeeRepo;

    @Autowired
    public AvailabilityStatusService(AvailabilityStatusRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public AvailabilityStatus addAvailabilityStatus(AvailabilityStatus employee) {
        return employeeRepo.save(employee);
    }

    public List<AvailabilityStatus> findAllAvailabilityStatuses() {
        return employeeRepo.findAll();
    }

    public void deleteAvailabilityStatus(Long id){
        AvailabilityStatus employee = employeeRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("AvailabilityStatus by id " + id + " was not found"));
        employeeRepo.delete(employee);
    }
}
