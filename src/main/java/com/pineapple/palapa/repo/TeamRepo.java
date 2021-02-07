package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.Team;

public interface TeamRepo extends JpaRepository<Team, Long> {

}
