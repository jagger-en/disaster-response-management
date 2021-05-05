package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.PointType;
import com.pineapple.palapa.repo.PointTypeRepo;

import java.util.List;

@Service
public class PointTypeService {
    private final PointTypeRepo pointTypeRepo;

    @Autowired
    public PointTypeService(PointTypeRepo pointTypeRepo) {
        this.pointTypeRepo = pointTypeRepo;
    }

    public PointType addPointType(PointType pointType) {
        return pointTypeRepo.save(pointType);
    }

    public List<PointType> findAllPointTypes() {
        return pointTypeRepo.findAll();
    }

    public void deletePointType(Long id){
        PointType pointType = pointTypeRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("PointType by id " + id + " was not found"));
        pointTypeRepo.delete(pointType);
    }
}
