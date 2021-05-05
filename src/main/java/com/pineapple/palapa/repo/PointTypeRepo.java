package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.PointType;

public interface PointTypeRepo extends JpaRepository<PointType, Long> {

}