package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.MissionAndStatus;

public interface MissionAndStatusRepo extends JpaRepository<MissionAndStatus, Long> {

}
