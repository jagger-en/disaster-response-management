package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.Mission;

public interface MissionRepo extends JpaRepository<Mission, Long> {

}