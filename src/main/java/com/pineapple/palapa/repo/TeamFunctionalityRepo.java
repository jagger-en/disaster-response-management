package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.TeamFunctionality;

import java.util.Optional;

public interface TeamFunctionalityRepo extends JpaRepository<TeamFunctionality, Long> {
    Optional<TeamFunctionality> findTeamFunctionalityById(Long id);
}
