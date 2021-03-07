package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.MissionTeam;

import java.util.Optional;

public interface MissionTeamRepo extends JpaRepository<MissionTeam, Long> {
    Optional<MissionTeam> findMissionTeamById(Long id);
}