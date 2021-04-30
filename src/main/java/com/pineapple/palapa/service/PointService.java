package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.Point;
import com.pineapple.palapa.repo.PointRepo;

import java.util.List;

@Service
public class PointService {
    private final PointRepo pointRepo;

    @Autowired
    public PointService(PointRepo pointRepo) {
        this.pointRepo = pointRepo;
    }

    public Point addPoint(Point point) {
        return pointRepo.save(point);
    }

    public List<Point> findAllPoints() {
        return pointRepo.getAllPoints();
    }

    public void deletePoint(Long id){
        Point point = pointRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("Point by id " + id + " was not found"));
        pointRepo.delete(point);
    }
}
