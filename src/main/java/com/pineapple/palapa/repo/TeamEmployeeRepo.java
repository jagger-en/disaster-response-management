package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.TeamEmployee;

import java.util.Optional;

public interface TeamEmployeeRepo extends JpaRepository<TeamEmployee, Long> {
    Optional<TeamEmployee> findTeamEmployeeById(Long id);
}
