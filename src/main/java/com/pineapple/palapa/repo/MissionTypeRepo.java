package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.MissionType;

import java.util.Optional;

public interface MissionTypeRepo extends JpaRepository<MissionType, Long> {
    Optional<MissionType> findMissionTypeById(Long id);
}