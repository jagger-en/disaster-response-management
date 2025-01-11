package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.MissionStatus;

public interface MissionStatusRepo extends JpaRepository<MissionStatus, Long> {

}