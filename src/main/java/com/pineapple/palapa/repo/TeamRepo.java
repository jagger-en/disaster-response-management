package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.Team;

import java.util.Optional;

public interface TeamRepo extends JpaRepository<Team, Long> {
    Optional<Team> findTeamById(Long id);
}
