package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.Mission;

import java.util.Optional;

public interface MissionRepo extends JpaRepository<Mission, Long> {
    Optional<Mission> findMissionById(Long id);
}