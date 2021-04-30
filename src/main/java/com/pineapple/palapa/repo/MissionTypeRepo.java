package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.MissionType;

public interface MissionTypeRepo extends JpaRepository<MissionType, Long> {

}